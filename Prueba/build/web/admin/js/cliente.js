let clientes;
export function insertarCliente() {

    let nombre = document.getElementById("txtNombreC").value;
    let app = document.getElementById("txtApellidopC").value;
    let apm = document.getElementById("txtApellidoMaC").value;
    let genero = document.getElementById("txtGeneroC").value;
    let fechaNac = document.getElementById("txtfechaC").value;
    let calle = document.getElementById("txtCalleC").value;
    let num = document.getElementById("txtNumC").value;
    let colonia = document.getElementById("txtColoniaC").value;
    let cp = document.getElementById("txtCpC").value;
    let ciudad = document.getElementById("txtCiudadC").value;
    let estado = document.getElementById("txtEstadoC").value;
    let telCasa = document.getElementById("txtTelCasaC").value;
    let telMo = document.getElementById("txtTelMovilC").value;
    let email = document.getElementById("txtEmailC").value;

    // alert(fechaNac);
    let persona = {nombre: nombre, apellidoPaterno: app, apellidoMaterno: apm, genero: genero, fechaNacimiento: fechaNac, calle: calle, numero: num, colonia: colonia, cp: cp, ciudad: ciudad, estado: estado, telCasa: telCasa, telMovil: telMo, email: email};

    let cliente = JSON.stringify({persona: persona});

    //JSON.stringify convierte en String

    let parametros = new URLSearchParams({datos: cliente});

    fetch('../api/cliente/insertar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                //let msj = "Empleado insertado con ID" + data.idEmpleado;
                //alert(msj);
                if (data.error)
                    alert(JSON.stringify(data));
                else
                    mandarConfirmacionGuardar();
            });
}

export function catalogoClientes() {
    let datos = {estatus: 1};
    let parametros = new URLSearchParams({datos});

    fetch('../api/cliente/getAll',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    cargarTable(data);
                }
            });
}

export function catalogoClientesInactivos() {
    let datos = {estatus: 0};
    let parametros = new URLSearchParams({datos});

    fetch('../api/cliente/getAllInacticvos',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    cargarTable(data);
                }
            });
}


export function cargarTable(data) {
    clientes = data;
    let contenidoTablaClientes = "";
    for (var i = 0; i < clientes.length; i++) {
        contenidoTablaClientes += "<tr>";
        let nombre = clientes[i].persona.nombre + "" + clientes[i].persona.apellidoPaterno + "" + clientes[i].persona.apellidoMaterno;
        contenidoTablaClientes += "<td>" + nombre + "</td>";
        let genero = clientes[i].persona.genero;
        contenidoTablaClientes += "<td>" + genero + "</td>";
        let fechaNac = clientes[i].persona.fechaNacimiento;
        contenidoTablaClientes += "<td>" + fechaNac + "</td>";
        let direccion = clientes[i].persona.calle + "" + clientes[i].persona.numero + " " + clientes[i].persona.colonia + " " + clientes[i].persona.cp + " " + clientes[i].persona.ciudad + "" + clientes[i].persona.estado;
        contenidoTablaClientes += "<td>" + direccion + "</td>";
        let tels = clientes[i].persona.telCasa + " " + clientes[i].persona.telMovil;
        contenidoTablaClientes += "<td>" + tels + "</td>";
        let correo = clientes[i].persona.email;
        contenidoTablaClientes += "<td>" + correo + "</td>";
        let numCli = clientes[i].idCliente;
        contenidoTablaClientes += "<td>" + numCli + "</td>";
        let estatus = clientes[i].estatus;
        contenidoTablaClientes += "<td>" + estatus + "</td>";

        contenidoTablaClientes += "<td><button class='btn btn-info' onclick='cm.cargarFrmCliente(" + i + ");'>Detalle</button></td>";

        if (estatus === 1) {
            contenidoTablaClientes += "<td><button class='btn btn-danger' onclick='cm.eliminar();'>Eliminar</button></td>";
        } else {
            contenidoTablaClientes += "<td><button  class='btn btn-success' onclick='cm.eliminar();'>Activar</button></td>";
        }

        contenidoTablaClientes += "</tr>";


    }

    document.getElementById("tbodyClientes").innerHTML = contenidoTablaClientes;
}

let idPer;
let idClie;
let status;
export function cargarFrmCliente(i) {

    document.getElementById("txtNombreC").value = clientes[i].persona.nombre;
    document.getElementById("txtApellidopC").value = clientes[i].persona.apellidoPaterno;
    document.getElementById("txtApellidoMaC").value = clientes[i].persona.apellidoMaterno;
    document.getElementById("txtGeneroC").value = clientes[i].persona.genero;
    document.getElementById("txtfechaC").value = clientes[i].persona.fechaNacimiento;
    document.getElementById("txtCalleC").value = clientes[i].persona.calle;
    document.getElementById("txtNumC").value = clientes[i].persona.numero;
    document.getElementById("txtColoniaC").value = clientes[i].persona.colonia;
    document.getElementById("txtCpC").value = clientes[i].persona.cp;
    document.getElementById("txtCiudadC").value = clientes[i].persona.ciudad;
    document.getElementById("txtEstadoC").value = clientes[i].persona.estado;
    document.getElementById("txtTelCasaC").value = clientes[i].persona.telCasa;
    document.getElementById("txtTelMovilC").value = clientes[i].persona.telMovil;
    document.getElementById("txtEmailC").value = clientes[i].persona.email;

    idPer = clientes[i].persona.idPersona;
    idClie = clientes[i].idCliente;
    status = clientes[i].estatus;

}

export function limpiar() {

    document.getElementById("txtNombreC").value = "";
    document.getElementById("txtApellidopC").value = "";
    document.getElementById("txtApellidoMaC").value = "";
    document.getElementById("txtGeneroC").value = "";
    document.getElementById("txtfechaC").value = "";
    document.getElementById("txtCalleC").value = "";
    document.getElementById("txtNumC").value = "";
    document.getElementById("txtColoniaC").value = "";
    document.getElementById("txtCpC").value = "";
    document.getElementById("txtCiudadC").value = "";
    document.getElementById("txtEstadoC").value = "";
    document.getElementById("txtTelCasaC").value = "";
    document.getElementById("txtTelMovilC").value = "";
    document.getElementById("txtEmailC").value = "";

}

export function actualizarCliente() {

    let nombre = document.getElementById("txtNombreC").value;
    let app = document.getElementById("txtApellidopC").value;
    let apm = document.getElementById("txtApellidoMaC").value;
    let genero = document.getElementById("txtGeneroC").value;
    let fechaNac = document.getElementById("txtfechaC").value;
    let calle = document.getElementById("txtCalleC").value;
    let num = document.getElementById("txtNumC").value;
    let colonia = document.getElementById("txtColoniaC").value;
    let cp = document.getElementById("txtCpC").value;
    let ciudad = document.getElementById("txtCiudadC").value;
    let estado = document.getElementById("txtEstadoC").value;
    let telCasa = document.getElementById("txtTelCasaC").value;
    let telMo = document.getElementById("txtTelMovilC").value;
    let email = document.getElementById("txtEmailC").value;

    // alert(fechaNac);
    let persona = {idPersona: idPer, nombre: nombre, apellidoPaterno: app, apellidoMaterno: apm, genero: genero, fechaNacimiento: fechaNac, calle: calle, numero: num, colonia: colonia, cp: cp, ciudad: ciudad, estado: estado, telCasa: telCasa, telMovil: telMo, email: email};

    let cliente = JSON.stringify({idCliente: idClie, persona: persona});

    //JSON.stringify convierte en String

    let parametros = new URLSearchParams({datos: cliente});

    fetch('../api/cliente/Actualizar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                //let msj = "Empleado insertado con ID" + data.idEmpleado;
                //alert(msj);
                if (data.error)
                    alert(JSON.stringify(data));
                else
                    mandarConfirmacionGuardar();
            });
}

export function eliminar() {

    if (status === 0) {
        status = 1;
    } else {
        status = 0;
    }

    let cliente = JSON.stringify({idCliente: idClie, estatus: status});
    let parametros = new URLSearchParams({datos: cliente});

    fetch('../api/cliente/Eliminar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data)
                    alert(JSON.stringify(data));
            });

}

export function buscarCliente() {

    let busqueda = document.getElementById("txtSearch").value;

    let parametro = {"buscar": busqueda};
    fetch('../api/cliente/buscar?busqueda=' + busqueda)
            .then(response => response.json())
            .then(data => {
                cargarTable(data);
                //alert(JSON.stringify(data));
            });
}