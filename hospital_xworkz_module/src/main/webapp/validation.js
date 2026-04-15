
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

   let regex = /^[A-Za-z0-9](\.?[A-Za-z0-9_-])*@[A-Za-z0-9-]+(\.[A-Za-z]{2,})+$/;
    if(!regex.test(emailInput)){
        emailError.textContent = "Enter a valid email";
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
        experienceInput.value = "";
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

function validateAge(){
     let ageInput = document.getElementById("age");
     let ageError = document.getElementById("ageError");

     ageInput.value = ageInput.value.replace( /[^0-9]/g, '');

     if(ageInput.value == 0 ){
         ageError.textContent = "age cannot be '0' ";
     }else if(ageInput.value > 120){
         ageInput.value = "";
         ageError.textContent = "age cannot be greater than 120";
     }else{
         ageError.textContent = "";
     }
}

function validateAddress(){
    let addressInput = document.getElementById("addressId");
    let addressError = document.getElementById("addressErrorId");

    if(addressInput.value.length < 10 || addressInput.value.length > 200) {
        addressError.textContent = "Address should be between 10-200 characters";
    }else{
        addressError.textContent = "";
    }
}

function validateSymptoms(){
    let symptomsInput = document.getElementById("symptomsId");
    let symptomsError = document.getElementById("symptomsErrorId");

    if(symptomsInput.value.length < 10 || symptomsInput.value.length > 400) {
        symptomsError.textContent = "Symptoms should be between 10-400 characters";
    }else{
        symptomsError.textContent = "";
    }
}

function checkEmailExists(){

    console.log("checkEmailExists called..")

    let email = document.getElementById("email").value;
    let errorMsg = document.getElementById("emailError");

    let regex = /^[A-Za-z0-9](\.?[A-Za-z0-9_-])*@[A-Za-z0-9-]+(\.[A-Za-z]{2,})+$/;

        // 🚨 FIRST check validity
        if(!regex.test(email)){
        errorMsg.innerHTML = "Enter valid email";
            return; // ❌ stop API call
        }


    axios.get("http://localhost:8080/hospital_xworkz_module/checkEmail",{
        params: {
            email: email
        }
    })
    .then(function(response){
            console.log("Response:", response.data);

            if(response.data === "exists"){
                errorMsg.innerHTML = "Email already exists";
            } else {
                errorMsg.innerHTML = "";
            }
        })
        .catch(function(error){
            console.log("Error:", error);
        });
}

function validateForm() {
    let emailInput = document.getElementById("email");
    let emailError = document.getElementById("emailError").innerHTML;

    if (emailError === "Email already exists") {
        alert("Email entered already exits , try agian");

        emailInput.value = "";

        document.getElementById("emailError").innerHTML = "";

        emailInput.focus();

        return false;
    }
    return true;
}
