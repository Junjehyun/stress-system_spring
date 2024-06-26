//追加するボタンを押した時、新規作成画面に遷移する
$(document).ready(function() {
    $("#moveCreateBtn").click(function(){
        window.location.href = "/doctor-create";
    }); 
});