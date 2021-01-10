/* global fetch */

var formulario = document.getElementById("formulario");
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    //var datos = new FormData(formulario);
    var data = JSON.stringify({id: '1', usuario: 'Milton', pan: '1754429361'});
    //console.log(JSON.stringify(data));
    fetch('Servidor', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: data
    }).then(response => response.json())
            .catch(error => console.error('Error:', error))
            .then(response => console.log('Success:', response));

});
