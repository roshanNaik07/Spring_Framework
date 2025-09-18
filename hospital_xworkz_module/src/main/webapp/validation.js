
function validateName(){
    let nameInput = document.getElementById("name");
    let nameError = document.getElementById("nameError");

    nameInput.value = nameInput.value.replace(/[^A-Za-z ]/g, '');

    if (nameInput.value.length < 3 || nameInput.value.length > 30) {
        nameError.textContent = "Name should be between 3-30 characters";
    } else {
        nameError.textContent = "";
    }
}

function validateSpecialization() {
    let specializationInput = document.getElementById("specialization").value;
    let specializationError = document.getElementById("specializationError");

    if(specializationInput === ""){
        specializationError.textContent = " Please select specialization ";
    }else
        specializationError.textContent = "";
}

function validateEmail(){
    let emailInput = document.getElementById("email").value;
    let emailError = document.getElementById("emailError");

    let regex = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;
    if(!regex.test(emailInput)){
        emailError.textContent = "Enter a valid email ending with @gmail.com.";
    }else{
        emailError.textContent = "";
    }
}

function validateExperience(){
    let experienceInput = document.getElementById("experience");
    let experienceError = document.getElementById("experienceError");

    experienceInput.value = experienceInput.value.replace( /[^0-9]/g, '');

    if(experienceInput.value == 0 ){
        experienceError.textContent = "Experience cannot be '0' ";
    }else if(experienceInput.value > 40){
        experienceError.textContent = "Experience cannot be greater than 40";
    }else{
        experienceError.textContent = "";
    }
}

function validatePhoneNumber(){
    console.log("Entered PhoneNo")
    let phoneNumberInput = document.getElementById("PhoneNumberId");
    let phoneNumberError = document.getElementById("phoneNumberErrorId");

    phoneNumberInput.value = phoneNumberInput.value.replace( /[^0-9]/g,'');
    if(phoneNumberInput.value.length != 10){
        phoneNumberError.textContent = "Phone Number should contain 10 digits";
    }else
        phoneNumberError.textContent = "";
}

function qualificationValidation() {
    let qualificationInput = document.getElementById("qualificationId");
    let qualificationError = document.getElementById("qualificationErrorId");

    qualificationInput.value = qualificationInput.value.replace(/[^A-Za-z.,() ]/g, '');

    if (qualificationInput.value.length < 2 || qualificationInput.value.length > 50) {
        qualificationError.textContent = "Enter a valid qualification (2 to 50 characters)";
    } else {
        qualificationError.textContent = "";
    }
}
