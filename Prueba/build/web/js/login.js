
function cargarLogin() {
fetch('admin/index.html')
        .then(respuesta => {
        return respuesta.text(); })
        .then(datos => {
        
        });
        }



function login()
{
    window.location.replace('admin/index.html');    
}

function logout()
{
    window.location.replace('/Prueba/index.html');   
}

