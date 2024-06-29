document.addEventListener('DOMContentLoaded', (event) => {
    document.querySelectorAll('.deleteBtn').forEach(button => {
        button.addEventListener('click', function() {
            var userId = this.getAttribute('data-id');

            if (confirm('本当に削除しますか?')) {
                fetch('/delete?userId=' + encodeURIComponent(userId), {
                    method: 'DELETE'
                })
                .then(response => {
                    if(response.ok) {
                        alert('削除されました。');
                        location.reload();
                    } else {
                        alert('削除処理ができませんでした。');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
            }
        });
    });
});
