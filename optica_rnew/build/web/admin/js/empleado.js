//Creamos el arreglo de empleados:
//let empleados = [
//    {
//        idEmpleado: 1,
//        numeroUnicoEmpleado: "JUA6374",
//        nombre: "Angel",
//        apellido_paterno: "Juarez",
//        apellido_materno: "Alvizo",
//        genero: "Masculino",
//        estatus: "Activo",
//        rfc: "NA",
//        telefono_casa: "4765647384",
//        telefono_movil: "4776452839",
//        correo_electronico: "gallo@gmail.com",
//        usuario: "empleadoGeneral",
//        contraseña: "12345"
//    },
//    {
//        idEmpleado: 2,
//        numeroUnicoEmpleado: "CAR4567",
//        nombre: "Keysi",
//        apellido_paterno: "Cardona",
//        apellido_materno: "Reyes",
//        genero: "Femenino",
//        estatus: "Inactivo",
//        rfc: "NA",
//        telefono_casa: "4763526364",
//        telefono_movil: "4778491202",
//        correo_electronico: "qeso@gmail.com",
//        usuario: "admin",
//        contraseña: "54321"
//    },
//    {
//        idEmpleado: 3,
//        numeroUnicoEmpleado: "COS456",
//        nombre: "Alan",
//        apellido_paterno: "Contreras",
//        apellido_materno: "Sanchez",
//        genero: "Masculino",
//        estatus: "Activo",
//        rfc: "NA",
//        telefono_casa: "4778642536",
//        telefono_movil: "4768492363",
//        correo_electronico: "cuasi@gmail.com",
//        usuario: "empleadoJorge",
//        contraseña: "67890"
//    }
//];

//Corrección 

export function inicializarEmpleado()
{
    setDetalleVisible(false);
    fillTable();
}
/**
 * Llena una tabla a partir de un Arreglo JSON.
 */
export function fillTable()
{
    //Declaramos una variable donde se guardara el contenido de la tabla:
    let contenido = '';
    //Recorrer el Arreglo
//    for (let i = 0; i < empleados.length; i++)
//    {
//        //Vamos generando el contenido de la tabla dinamicamente:
//        contenido = contenido + '<tr>' +
//                '<td>' + empleados[i].nombre + '</td>' +
//                '<td>' + empleados[i].correo_electronico + '</td>' +
//                '<td>' + empleados[i].telefono_casa + '</td>' +
//                '<td>' + empleados[i].telefono_movil + '</td>' +
//                '<td><a href="#" onclick="cm.mostrarDetalleEmpleado(' +
//                empleados[i].idEmpleado + ');">Ver Detalle</a></td>' +
//                '</tr>';
//    }
    document.getElementById('tbodyEmpleados').innerHTML = contenido;
}
//Muestra y oculta el detalle del Empleado
export function setDetalleVisible(valor)
{
    //El tripe igual es para comparar valores
    //Cuando es con doble igual es para comparar objetos
    if (valor === true)
    {
        document.getElementById("divDetalle").style.display = "";
        document.getElementById("divCatalogo").style.display = "none";
    } else
    {
        document.getElementById("divDetalle").style.display = "none";
        document.getElementById("divCatalogo").style.display = "";
    }
}

function formatearFecha(valor) {
   
//    let date = new Date(fecha); 
//    const formatDate = (date) => {
//        let formatted_date = (date.getDate()+1)+ "/" + (date.getMonth() + 1) + "/" + date.getFullYear();
//        return formatted_date;
//    }
//    console.log(formatDate(date));
    let fecha=valor;
    let va1;
    let va2;
    let va3;
    let va4;
    let va5;
    let va6;
    let va7;
    let va8;
    let va9="/";
    let va10="/";
    
    va1=fecha.toString().charAt(8);
    va2=fecha.toString().charAt(9);
    va3=fecha.toString().charAt(5);
    va4=fecha.toString().charAt(6);
    va5=fecha.toString().charAt(0);
    va6=fecha.toString().charAt(1);
    va7=fecha.toString().charAt(2);
    va8=fecha.toString().charAt(3);
    
    fecha=va1+va2+va9+va3+va4+va10+va5+va6+va7+va8;
    return fecha;
    //alert(fecha);
}




export function empleado() {
    
    let nombre = document.getElementById("txtNombre").value;
    let app = document.getElementById("txtApellidop").value;
    let apm = document.getElementById("txtApellidoMa").value;
    let genero = document.getElementById("txtGenero").value;
    let fechaNac = document.getElementById("txtfecha").value;
    fechaNac=formatearFecha(fechaNac);
    let calle = document.getElementById("txtCalle").value;
    let num = document.getElementById("txtNum").value;
    let colonia = document.getElementById("txtColonia").value;
    let cp = document.getElementById("txtCp").value;
    let ciudad = document.getElementById("txtCiudad").value;
    let estado = document.getElementById("txtEstado").value;
    let telCasa = document.getElementById("txtTelCasa").value;
    let telMo = document.getElementById("txtTelMovil").value;
    let email = document.getElementById("txtEmail").value;

    let us = document.getElementById("txtUsuario").value;
    let contrasennia = document.getElementById("pwdContraseña").value;
    let rol = document.getElementById("txtRol").value;

   // alert(fechaNac);

    

    let usuario = {nombre: us, contrasenia: contrasennia, rol: rol};

    let persona = {nombre: nombre, apellidoPaterno: app, apellidoMaterno: apm, genero: genero, fechaNacimiento: fechaNac, calle: calle, numero: num, colonia: colonia, cp: cp, ciudad: ciudad, estado: estado, telCasa: telCasa, telMovil: telMo, email: email};

    let empleado = JSON.stringify({usuario: usuario, persona: persona});

    //JSON.stringify convierte en String

    let parametros = new URLSearchParams({datos: empleado});

    fetch('api/empleado/insertar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                let msj ="Empleado insertado con ID"+data.idEmpleado; 
                //JSON.stringify(data);
                alert(msj);
            });


}





