let empleados;
export function formatearFecha(valor) {

//    let date = new Date(valor); 
//    const formatDate = (date) => {
//        let formatted_date = (date.getDate()+1)+ "/" + (date.getMonth() + 1) + "/" + date.getFullYear();
//        return formatted_date;
//    }
//    console.log(formatDate(date));
//    let fecha = valor;
//    let va1;
//    let va2;
//    let va3;
//    let va4;
//    let va5;
//    let va6;
//    let va7;
//    let va8;
//    let va9 = "/";
//    let va10 = "/";
//
//    va1 = fecha.toString().charAt(8);
//    va2 = fecha.toString().charAt(9);
//    va3 = fecha.toString().charAt(5);
//    va4 = fecha.toString().charAt(6);
//    va5 = fecha.toString().charAt(0);
//    va6 = fecha.toString().charAt(1);
//    va7 = fecha.toString().charAt(2);
//    va8 = fecha.toString().charAt(3);
//
//    fecha = va1 + va2 + va9 + va3 + va4 + va10 + va5 + va6 + va7 + va8;
//    return fecha;
    //alert(fecha);
}

export function empleado() {

    let nombre = document.getElementById("txtNombre").value;
    let app = document.getElementById("txtApellidop").value;
    let apm = document.getElementById("txtApellidoMa").value;
    let genero = document.getElementById("txtGenero").value;
    let fechaNac = document.getElementById("txtfecha").value;
//    fechaNac = formatearFecha(fechaNac);
    let calle = document.getElementById("txtCalle").value;
    let num = document.getElementById("txtNum").value;
    let colonia = document.getElementById("txtColonia").value;
    let cp = document.getElementById("txtCp").value;
    let ciudad = document.getElementById("txtCiudad").value;
    let estado = document.getElementById("txtEstado").value;
    let telCasa = document.getElementById("txtTelCasa").value;
    let telMo = document.getElementById("txtTelMovil").value;
    let email = document.getElementById("txtEmail").value;

    let us = document.getElementById("txtUser").value;
    let contrasennia = document.getElementById("txtContrassenia").value;
    let rol = document.getElementById("txtRol").value;

    // alert(fechaNac);
    let usuario = {nombre: us, contrasenia: contrasennia, rol: rol};

    let persona = {nombre: nombre, apellidoPaterno: app, apellidoMaterno: apm, genero: genero, fechaNacimiento: fechaNac, calle: calle, numero: num, colonia: colonia, cp: cp, ciudad: ciudad, estado: estado, telCasa: telCasa, telMovil: telMo, email: email};

    let empleado = JSON.stringify({usuario: usuario, persona: persona});

    //JSON.stringify convierte en String

    let parametros = new URLSearchParams({datos: empleado});

    fetch('../api/empleado/insertar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                //let msj = "Empleado insertado con ID" + data.idEmpleado;
                //alert(msj);
                if (data.error)
                  //alert(JSON.stringify(data));
                      mandarError();
                else
                    mandarConfirmacionGuardar();
            });
}


export function catalogoEmpleado() {
    let datos = {estatus: 1};
    let parametros = new URLSearchParams({datos});

    fetch('../api/empleado/getAll',
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

export function catalogoEmpleadoInac() {
    let datos = {estatus: 0};
    let parametros = new URLSearchParams({datos});

    fetch('../api/empleado/getAllInactivos',
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

let idUs;
let idPe;
let idEm;
let estatus;

export function cargarTable(data) {
    empleados = data;
    let contenidoTablaEmpleados = "";
    for (var i = 0; i < empleados.length; i++) {
        contenidoTablaEmpleados += "<tr>";
        let nombre = empleados[i].persona.nombre + "" + empleados[i].persona.apellidoPaterno + "" + empleados[i].persona.apellidoMaterno;
        contenidoTablaEmpleados += "<td>" + nombre + "</td>";
        let genero = empleados[i].persona.genero;
        contenidoTablaEmpleados += "<td>" + genero + "</td>";
        let fechaNac = empleados[i].persona.fechaNacimiento;
        contenidoTablaEmpleados += "<td>" + fechaNac + "</td>";
        let direccion = empleados[i].persona.calle + "" + empleados[i].persona.numero + " " + empleados[i].persona.colonia + " " + empleados[i].persona.cp + " " + empleados[i].persona.ciudad + "" + empleados[i].persona.estado;
        contenidoTablaEmpleados += "<td>" + direccion + "</td>";
        let tels = empleados[i].persona.telCasa + " " + empleados[i].persona.telMovil;
        contenidoTablaEmpleados += "<td>" + tels + "</td>";
        let correo = empleados[i].persona.email;
        contenidoTablaEmpleados += "<td>" + correo + "</td>";
        let usuario = empleados[i].usuario.nombre;
        contenidoTablaEmpleados += "<td>" + usuario + "</td>";
        let numUsu = empleados[i].usuario.idUsuario;
        contenidoTablaEmpleados += "<td>" + numUsu + "</td>";
        let status = empleados[i].estatus;
        contenidoTablaEmpleados += "<td>" + status + "</td>";

        contenidoTablaEmpleados += "<td><button class='btn btn-info' onclick='cm.cargarFrmEm(" + i + ");'>Detalle</button></td>";

        if (status === 1) {
            contenidoTablaEmpleados += "<td><button class='btn btn-danger' onclick='cm.eliminar();'>Eliminar</button></td>";
        } else {
            contenidoTablaEmpleados += "<td><button  class='btn btn-success' onclick='cm.eliminar();'>Activar</button></td>";
        }

        contenidoTablaEmpleados += "</tr>";
    }

    document.getElementById("tbodyEmpleados").innerHTML = contenidoTablaEmpleados;
}


//cargarFrmEm ---- Cargar formulario empleados 
export function cargarFrmEm(i) {
    //alert(i);
    document.getElementById("txtNombre").value = empleados[i].persona.nombre;
    document.getElementById("txtApellidop").value = empleados[i].persona.apellidoPaterno;
    document.getElementById("txtApellidoMa").value = empleados[i].persona.apellidoMaterno;
    document.getElementById("txtGenero").value = empleados[i].persona.genero;
    document.getElementById("txtfecha").value = empleados[i].persona.fechaNacimiento;
    document.getElementById("txtCalle").value = empleados[i].persona.calle;
    document.getElementById("txtNum").value = empleados[i].persona.numero;
    document.getElementById("txtColonia").value = empleados[i].persona.colonia;
    document.getElementById("txtCp").value = empleados[i].persona.cp;
    document.getElementById("txtCiudad").value = empleados[i].persona.ciudad;
    document.getElementById("txtEstado").value = empleados[i].persona.estado;
    document.getElementById("txtTelCasa").value = empleados[i].persona.telCasa;
    document.getElementById("txtTelMovil").value = empleados[i].persona.telMovil;
    document.getElementById("txtEmail").value = empleados[i].persona.email;
    document.getElementById("txtUser").value = empleados[i].usuario.nombre;
    document.getElementById("txtRol").value = empleados[i].usuario.rol;
    

    idUs = empleados[i].usuario.idUsuario;
    idPe = empleados[i].persona.idPersona;
    idEm = empleados[i].idEmpleado;
    estatus = empleados[i].estatus;

}


export function limpiar() {
    document.getElementById("txtNombre").value = "";
    document.getElementById("txtApellidop").value = "";
    document.getElementById("txtApellidoMa").value = "";
    document.getElementById("txtGenero").value ="Genero";
    document.getElementById("txtfecha").value = "";
    document.getElementById("txtCalle").value = "";
    document.getElementById("txtNum").value = "";
    document.getElementById("txtColonia").value = "";
    document.getElementById("txtCp").value = "";
    document.getElementById("txtCiudad").value = "";
    document.getElementById("txtEstado").value ="Seleccione un Estado...";
    document.getElementById("txtTelCasa").value = "";
    document.getElementById("txtTelMovil").value = "";
    document.getElementById("txtEmail").value = "";
    document.getElementById("txtUser").value = "";
    document.getElementById("txtRol").value ="Rol";
    

}

export function actualizarEmpleado() {
    
    //alert(idUs + " " + idPe + " " + idEm);

    let nombre = document.getElementById("txtNombre").value;
    let app = document.getElementById("txtApellidop").value;
    let apm = document.getElementById("txtApellidoMa").value;
    let genero = document.getElementById("txtGenero").value;
    let fechaNac = document.getElementById("txtfecha").value;
    //fechaNac = formatearFecha(fechaNac);
    let calle = document.getElementById("txtCalle").value;
    let num = document.getElementById("txtNum").value;
    let colonia = document.getElementById("txtColonia").value;
    let cp = document.getElementById("txtCp").value;
    let ciudad = document.getElementById("txtCiudad").value;
    let estado = document.getElementById("txtEstado").value;
    let telCasa = document.getElementById("txtTelCasa").value;
    let telMo = document.getElementById("txtTelMovil").value;
    let email = document.getElementById("txtEmail").value;
    let us = document.getElementById("txtUser").value;
    let contrasennia = document.getElementById("txtContrassenia").value;
    let rol = document.getElementById("txtRol").value;

    if (nombre===null) {
        mandarErrorActualizar();
    }
    // alert(fechaNac);
    let usuario = {idUsuario: idUs, nombre: us, contrasenia: contrasennia, rol: rol};

    let persona = {idPersona: idPe, nombre: nombre, apellidoPaterno: app, apellidoMaterno: apm, genero: genero, fechaNacimiento: fechaNac, calle: calle, numero: num, colonia: colonia, cp: cp, ciudad: ciudad, estado: estado, telCasa: telCasa, telMovil: telMo, email: email};

    let empleado = JSON.stringify({idEmpleado: idEm, usuario: usuario, persona: persona});

    //JSON.stringify convierte en String

    let parametros = new URLSearchParams({datos: empleado});
    
    
    fetch('../api/empleado/Actualizar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error)
                    mandarErrorActualizar();
                    //alert(JSON.stringify(data));
                else
                    mandarConfirmacionActualizar();
            });
        
}

export function eliminar() {
    if (estatus === 0) {
        estatus = 1;
    } else {
        estatus = 0;
    }

    let empleado = JSON.stringify({idEmpleado: idEm, estatus: estatus});
    let parametros = new URLSearchParams({datos: empleado});

    fetch('../api/empleado/Eliminar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data)
                    //alert(JSON.stringify(data));
                    mandarConfirmacionEliminar();
            });
            
}



export function buscarEmpleado() {

    let busqueda = document.getElementById("txtSearch").value;

    let parametro = {"buscar": busqueda};
    fetch('../api/empleado/buscar?busqueda=' + busqueda)
            .then(response => response.json())
            .then(data => {
                cargarTable(data);
                //alert(JSON.stringify(data));
            });
}