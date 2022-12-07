let tratamientos;
export function insertarTratamiento() {
    let nom = document.getElementById("txtNombreTr").value;
    let precioCom = document.getElementById("txtPrecioComTr").value;
    let precioVen = document.getElementById("txtPrecioVenTr").value;

    let tratamiento = {nombre: nom, precioCompra: precioCom, precioVenta: precioVen};

    let tratamientos = JSON.stringify(tratamiento);

    let parametros = new URLSearchParams({datos: tratamientos});

//    alert(JSON.stringify(parametros));
    fetch('../api/tratamiento/insertarTratamiento',
            {
                method: 'POST',
                body: parametros,
                headers: ({'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'})

            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {

                    Swal.fire(
                            'MUY BIEN!!!',
                            'Tratamiento insertado correctamente',
                            'success'
                            );
                }

            });
}

export function catalogoTratamiento() {
    let datos = {estatus: 1};
    let parametros = new URLSearchParams({datos});

    fetch('../api/tratamiento/getAllTratamiento',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    cargarTablaTratamiento(data);
                }
            });
}

export function catalogoMaterialInTratamiento() {
    let datos = {estatus: 0};
    let parametros = new URLSearchParams({datos});

    fetch('../api/tratamiento/getAllInactivosTratamientos',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    cargarTablaTratamiento(data);
                }
            });
}

export function cargarTablaTratamiento(data) {
    tratamientos = data;
    let contenidoTablaTratamiento = "";
    for (var i = 0; i < tratamientos.length; i++) {
        contenidoTablaTratamiento += "<tr>";
        let nombre = tratamientos[i].nombre;
        contenidoTablaTratamiento += "<td>" + nombre + "</td>";
        let pc = tratamientos[i].precioCompra;
        contenidoTablaTratamiento += "<td>" + pc + "</td>";
        let pv = tratamientos[i].precioVenta;
        contenidoTablaTratamiento += "<td>" + pv + "</td>";
        let estatus = tratamientos[i].estatus;
        contenidoTablaTratamiento += "<td>" + estatus + "</td>";

        contenidoTablaTratamiento += "<td><button class='btn btn-info' onclick='cm.cargarDatosFormTratamiento(" + i + ");'>Detalle</button></td>";
        
        if (estatus===1) {
            contenidoTablaTratamiento+="<td><button class='btn btn-danger' onclick='cm.eliminarTratamiento();'>Eliminar</button></td>";
        }else{
            contenidoTablaTratamiento+="<td><button class='btn btn-success' onclick='cm.eliminarTratamiento();'>Activar</button></td>";
        }
        contenidoTablaTratamiento += "</tr>";
    }

    document.getElementById("tbodyTratamientos").innerHTML = contenidoTablaTratamiento;
}
let idTra;
let estatus;
export function cargarDatosFormTratamiento(i) {
//    alert(i);
    document.getElementById("txtNombreTr").value = tratamientos[i].nombre;
    document.getElementById("txtPrecioComTr").value = tratamientos[i].precioCompra;
    document.getElementById("txtPrecioVenTr").value = tratamientos[i].precioVenta;

    idTra = tratamientos[i].idTratamiento;
    estatus = tratamientos[i].estatus;

//    alert(idMat + " " + estatus);
}
export function limpiarFormularioTratamiento() {
    document.getElementById("txtNombreTr").value = "";
    document.getElementById("txtPrecioComTr").value = "";
    document.getElementById("txtPrecioVenTr").value = "";
}

export function eliminarTratamiento() {

    if (estatus === 1) {
        estatus = 0;
    } else {
        estatus = 1;
    }
    let tratamiento = JSON.stringify({idTratamiento: idTra, estatus: estatus});
    let parametros = new URLSearchParams({datos: tratamiento});

//    alert(JSON.stringify(parametros));
    fetch('../api/tratamiento/BorrarTratamiento',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    Swal.fire({
                        title: '¿Estas seguro de cambiar el estatus?',
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonColor: '#3085d6',
                        cancelButtonColor: '#d33',
                        confirmButtonText: 'si, cambialo!'
                    }).then((result) => {
                        if (result.isConfirmed) {
                            Swal.fire(
                                    'Grandioso!',
                                    'el tratamiento cambio de estatus.',
                                    'success'
                                    );
                        }
                    });
                }
            });
}

export function modificarTratamiento() {

    let nom = document.getElementById("txtNombreTr").value;
    let precioCompra = document.getElementById("txtPrecioComTr").value;
    let precioVenta = document.getElementById("txtPrecioVenTr").value;

    let tratamiento = {idTratamiento: idTra,
        nombre: nom,
        precioCompra: precioCompra,
        precioVenta: precioVenta
    };

    let tratamientos = JSON.stringify(tratamiento);
    let parametros = new URLSearchParams({datos: tratamientos});

    fetch('../api/tratamiento/modificarTratamiento',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    Swal.fire({
                        title: '¿Deseas modificar el tratamiento?',
                        showDenyButton: true,
                        showCancelButton: true,
                        confirmButtonText: 'Modificar',
                        denyButtonText: `No modificar`,
                    }).then((result) => {
                        /* Read more about isConfirmed, isDenied below */
                        if (result.isConfirmed) {
                            Swal.fire('Modificado!', '', 'success')
                        } else if (result.isDenied) {
                            Swal.fire('No se modifico', '', 'info')
                        }
                    });

                }
            });
}
export function buscarTratamiento() {
    let buscar = document.getElementById("txtSearch").value;
    let parametros = {"buscar": buscar};

    fetch('../api/tratamiento/BuscarTratamiento?buscar=' + buscar)
            .then(response => response.json())
            .then(data => {
                cargarTablaTratamiento(data);
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Se encontro el tratamiento',
                    showConfirmButton: false,
                    timer: 1500
                });

            });

}
