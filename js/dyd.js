window.onload = function() {
	// Get the input field
	var inputCommand = document.getElementById("inputCommand");

	// Execute a function when the user releases a key on the keyboard
	inputCommand.addEventListener("keyup", function(event) {
		// Number 13 is the "Enter" key on the keyboard
		if (event.keyCode === 13) {
			// Cancel the default action, if needed
			event.preventDefault();
			// Trigger the button element with a click
			document.getElementById("send").click();
		}
	});
};

function sendCommand() {
	var inputCommand = document.getElementById("inputCommand");
	var commandHist = document.getElementById("commandHistLog");
	if (inputCommand.value.trim().length > 0) {
		$.post("Commands", {
			Command : inputCommand.value
		}).done(function(data) {
			commandHist.innerHTML = data;
		}).fail(function(jqXHR, textStatus, errorThrown) {
			alert("error" + textStatus + ":" + errorThrown);
			console.log(jqXHR);
		}).always(function() {
			
			inputCommand.value = "";
			$.getJSON('Character', function(character) {
                $('#characterHp').html(character.hp); 
                $('#location').html(character.location); 
                $('#battleStat').html(character.battleStat); 
            }); 
		});
	}
}