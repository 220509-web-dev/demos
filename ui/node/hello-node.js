const fs = require('fs');

let submissionResults = JSON.parse(fs.readFileSync('data.json'));

submissionResults.models.filter(sub => sub.hacker_username === 'david4vandal')
.forEach(model => {
    console.log(model)
});