// Function to validate Registration Form
function validateRegistrationForm() {
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();
    const confirmPassword = document.getElementById("confirmPassword").value.trim();

    let isValid = true;

    // Name Validation
    if (name === "") {
        showError("nameError", "Name is required");
        isValid = false;
    } else {
        clearError("nameError");
    }

    // Email Validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (email === "" || !emailRegex.test(email)) {
        showError("emailError", "Valid email is required");
        isValid = false;
    } else {
        clearError("emailError");
    }

    // Password Validation
    if (password === "") {
        showError("passwordError", "Password is required");
        isValid = false;
    } else if (password.length < 6) {
        showError("passwordError", "Password must be at least 6 characters long");
        isValid = false;
    } else {
        clearError("passwordError");
    }

    // Confirm Password Validation
    if (confirmPassword !== password) {
        showError("confirmPasswordError", "Passwords do not match");
        isValid = false;
    } else {
        clearError("confirmPasswordError");
    }

    return isValid;
}

// Function to validate Login Form
function validateLoginForm() {
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    let isValid = true;

    // Email Validation
    if (email === "") {
        showError("emailError", "Email is required");
        isValid = false;
    } else {
        clearError("emailError");
    }

    // Password Validation
    if (password === "") {
        showError("passwordError", "Password is required");
        isValid = false;
    } else {
        clearError("passwordError");
    }

    return isValid;
}

// Helper Functions
function showError(elementId, errorMessage) {
    const element = document.getElementById(elementId);
    element.innerText = errorMessage;
    element.style.display = "block";
}

function clearError(elementId) {
    const element = document.getElementById(elementId);
    element.innerText = "";
    element.style.display = "none";
}