function validateForm() {
	var form = document.getElementById("staffForm");

	var hasIdError = validateId(form);
	var validatename = validateName(form);
	var valMail = validateMail(form);
	
	if (!hasIdError || !validatename || !valMail) {
		return false;
	} else {
		return true;
	}
}

function validateId(form) {
	var val = document.getElementById("idStaff");
	var id = form["idStaff"].value;

	if (id == null || id == "") {
		val.className += " error";
		return false;
	}
	val.classList.remove("error");
	return true;
}

function validateName(form) {
	var val = document.getElementById("nameStaff");
	var name = form["nameStaff"].value;
	if (name == null || name == "") {
		val.className += " error";
		return false;
	}
	val.classList.remove("error");
	return true;
}

function validateMail(form) {
	var val = document.getElementById("email");
	val.classList.remove("error");
	var mail = form["email"].value;
	
	var regx = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	if (email == null || email == "" || !mail.match(regx)) {
		val.className += " error";
		return false;
	}
	val.classList.remove("error");
	return true;
}
