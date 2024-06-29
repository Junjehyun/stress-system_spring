//追加するボタンを押した時、新規作成画面に遷移する
$(document).ready(function() {

    $("#moveCreateBtn").click(function(){
        var companyCheckValue = $("#companyCheck").is(":checked") ? "true" : "false";
        var soshikiCheckValue = $("#soshikiCheck").is(":checked") ? "true" : "false";
        var kengenCheckValue = $("#kengenCheck").is(":checked") ? "true" : "false";

        var companyNameInputValue = $("#companyNameInput").val();
        var soshikiNameInputValue = $("#soshikiNameInput").val();

        var companyNameOutputValue = $("#companyNameOutput").val();

        var kengenKubunValue = $("input[name='kengenKubun']:checked").val();

        window.location.href = "/doctor-create?hiddenCompanyCheck=" + companyCheckValue +
            "&hiddenSoshikiCheck=" + soshikiCheckValue +
            "&hiddenKengenCheck=" + kengenCheckValue +
            "&hiddenCompanyNameInput=" + encodeURIComponent(companyNameInputValue) +
            "&hiddenSoshikiNameInput=" + encodeURIComponent(soshikiNameInputValue) +
            "&hiddenCompanyNameOutput=" + encodeURIComponent(companyNameOutputValue) +
            "&hiddenKengenKubun=" + encodeURIComponent(kengenKubunValue);
    }); 
});