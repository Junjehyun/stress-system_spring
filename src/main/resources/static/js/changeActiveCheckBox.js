function changeActiveCheckBox() {
    
    var companyCheck = document.getElementById("companyCheck").checked;
    var soshikiCheck = document.getElementById("soshikiCheck").checked;
    var kengenCheck = document.getElementById("kengenCheck").checked;

    var companyNameInput = document.getElementById("companyNameInput");
    var searchKaisyaBtn = document.querySelector('button[onclick="searchCompanies()"]');
    var companyNameOutput = document.getElementById("companyNameOutput");

    var soshikiNameInput = document.getElementById("soshikiNameInput");
    var searchSoshikiBtn = document.querySelector('button[onclick="searchSoshikis()"]');
    var soshikiNameOutput = document.getElementById("soshikiNameOutput");

    var kengenKubunRadios = document.querySelectorAll('input[name="kengenKubun"]');

    companyNameInput.disabled = !companyCheck;
    searchKaisyaBtn.disabled = !companyCheck;
    companyNameOutput.disabled = !companyCheck;

    soshikiNameInput.disabled = !soshikiCheck;
    searchSoshikiBtn.disabled = !soshikiCheck;
    soshikiNameOutput.disabled = !soshikiCheck;

    //チェックボックス初期化
    kengenKubunRadios.forEach(function(radio) {
        if(!kengenCheck) {
            radio.checked = false;
        }
        radio.disabled = !kengenCheck;
    });
}

document.addEventListener("DOMContentLoaded", function() {
    changeActiveCheckBox();
});