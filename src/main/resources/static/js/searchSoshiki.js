// ajax soshiki search
function searchSoshikis() {
    var soshikiName = document.getElementById('soshikiNameInput').value;

    if(!soshikiName) {
        alert('組織名を入力してください。');
        return;
    }

    $.ajax({
        url: '/soshiki-search',
        type: 'GET',
        data: {
            soshikiName: soshikiName
        },
        success: function(data) {
            var select = document.getElementById('soshikiSelect');
            select.innerHTML = '<option value="">検索結果確認!</option>';
            data.forEach(function(soshiki){
                var option = document.createElement('option');
                option.value = soshiki.soshikiCode;
                option.text = soshiki.soshikiNameJpn;
                select.appendChild(option);
            });
        }
    });
}