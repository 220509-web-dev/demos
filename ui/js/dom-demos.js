window.onload = function() {
    console.log('The page loaded!');
    let button = document.getElementById('login-button');
    button.addEventListener('click', login);

    let passwordField = document.getElementById('login-password');
    passwordField.addEventListener('keyup', function(e) {
        if (e.key === 'Enter') {
            login();
        }
    });
}

function login() {

    // Convenience references
    let usernameInput = document.getElementById('login-username');
    let passwordInput = document.getElementById('login-password');
    let errorContainer = document.getElementById('error-message');
    
    let username = usernameInput.value;
    let password = passwordInput.value;

    if (username && password) {
        
        // If the error message is being displayed, hide it
        errorContainer.setAttribute('hidden', true);

        let respData = fetch('http://localhost:8080/quizzard/auth', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username, password})
        }).then(resp => {
            console.log(`Response status: ${resp.status}`);
            console.log(`Response timestamp: ${Date.now()}`);

            if (resp.status != 200) {
                errorContainer.removeAttribute('hidden');
                errorContainer.innerText = "Login failed!";
                return;
            }

            return resp.json();
        })
        
        if (respData) {
            respData.then(data => {
                let successMsgContainer = document.createElement('p');
                successMsgContainer.setAttribute('class', 'alert alert-success');
                successMsgContainer.innerText = `Login successful! Welcome, ${data['firstName']}!`;
                document.getElementById('login-container').appendChild(successMsgContainer);
            });
        }

    } else {

        // Show the error message
        errorContainer.removeAttribute('hidden');
        errorContainer.innerText = "You must provide a username and password!";
        
    }

}
