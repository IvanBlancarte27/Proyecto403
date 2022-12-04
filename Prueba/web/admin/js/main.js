let cm = null;
        function cerrarModulo()
        {
        window.location.replace('./index.html');
        }

function cargarModuloEmpleado() {
fetch('empleado/empleado.html')
        .then(respuesta => {
        return respuesta.text(); })
        .then(datos => {
        document.getElementById('contenedor_principal').innerHTML = datos;
        import('./empleado.js').then(obj => {
        cm = obj;
        });
        });
        }

function cargarModuloAccesorio(){
//AJAX: Asynchronous
fetch('productos/accesorios/accesorios.html')
        .then(respuesta => {
        //Devolvemos el contenido
        //de la respuesta en formato
        //texto:
        return respuesta.text();
        })
        .then(datos => {
        //Insertamos el codigo HTML
        //dentro del contenedor principal
        document.getElementById('contenedor_principal').innerHTML = datos;
        import('./accesorios.js')
                .then(obj => {
                cm = obj;
                });
        });
}

function cargarModuloLentes(){
    //AJAX: Asynchronous
fetch('productos/lentes_contacto/lentesdecontacto.html')
        .then(respuesta => {
        //Devolvemos el contenido
        //de la respuesta en formato
        //texto:
        return respuesta.text();
        })
        .then(datos => {
        //Insertamos el codigo HTML
        //dentro del contenedor principal
        document.getElementById('contenedor_principal').innerHTML = datos;
        import('./lentesdecontacto.js')
                .then(obj => {
                cm = obj;
                });
        });
}

function cargarModuloSolucion(){
    //AJAX: Asynchronous
fetch('productos/solucion/solucion.html')
        .then(respuesta => {
        //Devolvemos el contenido
        //de la respuesta en formato
        //texto:
        return respuesta.text();
        })
        .then(datos => {
        //Insertamos el codigo HTML
        //dentro del contenedor principal
        document.getElementById('contenedor_principal').innerHTML = datos;
        import('./solucion.js')
                .then(obj => {
                cm = obj;
                });
        });
}

function cargarModuloClientes() {
fetch('cliente/cliente.html')
        .then(respuesta => {
        return respuesta.text(); })
        .then(datos => {
        document.getElementById('contenedor_principal').innerHTML = datos;
        import('./cliente.js').then(obj => {
        cm = obj;
        });
        });
        }