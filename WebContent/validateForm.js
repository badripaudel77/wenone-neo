
function validate() {
	var uname = document.getElementById('un').value;
	var upass = document.getElementById('pass').value;

	if(uname=="") {
		
		document.getElementById('unameErr').innerHTML = "*** Please fill up UserName Details.";
		
		document.getElementById('unameErr').style.visibility="visible";

		return false;
	}
	
if(upass=="") {
		
		document.getElementById('passErr').innerHTML = "*** Please fill up Password Details.";
		document.getElementById('passErr').style.visibility="visible";
		
		return false;
	}
 
	return true;
}