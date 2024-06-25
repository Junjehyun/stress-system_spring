// ajax company search
function searchCompanies() {
    var name = document.getElementById('companyNameInput').value;

    if (!name) {
        alert('会社名を入力してください。');
        return;
    }

    $.ajax({
        url: '/company-search',
        type: 'GET',
        data: {
            name: name
        },
        success: function(data) {
            var select = document.getElementById('companyNameOutput');
            select.innerHTML = '<option value="">検索結果確認!</option>';
            data.forEach(function(company){
                var option = document.createElement('option');
                option.value = company.kaisyaCode;
                option.text = company.kaisyaNameJpn;
                select.appendChild(option);
            });
        }
    });
}