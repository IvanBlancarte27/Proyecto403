export function insertarSolucion() {
    let nom = document.getElementById("txtNombre").value;
    let m = document.getElementById("txtMarca").value;
    let ex = document.getElementById("txtExistencias").value;
    let pc = document.getElementById("txtPrecioCompra").value;
    let pv = document.getElementById("txtPrecioVenta").value;

    let producto = ({nombre: nom, marca: m, existencias: ex, precioCompra: pc, precioVenta: pv});
    let solucion = JSON.stringify({producto: producto});
    let parametros = new URLSearchParams({datos: solucion});

    fetch('../api/solucion/insertarsolucion',
            {
                method: 'POST',
                body: parametros,
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                if (data.error!=null) {
                    alert(JSON.stringify(data));
                }
                mandarConfirmacionGuardar();
            });

}

export function catalogoSoluciones() {
    let datos = {estatus: 1};
    let parametros = new URLSearchParams({datos});
    fetch('../api/solucion/getAll',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    cargarTablaSO(data);
                }

            });
}
export function catalogoSolucionesInactivo() {
    let datos = {estatus: 0};
    let parametros = new URLSearchParams({datos});
    fetch('../api/solucion/getAll2',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    cargarTablaSO(data);
                }

            });
}
export function cargarTablaSO(data) {
    soluciones = data;
    let contenidoTC = "";
    for (var i = 0; i < soluciones.length; i++) {
        contenidoTC += "<tr>";
        let nombre = soluciones[i].producto.nombre;
        contenidoTC += "<td>" + nombre + "</td>";
        let marca = soluciones[i].producto.marca;
        contenidoTC += "<td>" + marca + "</td>";
        let existencias = soluciones[i].producto.existencias;
        contenidoTC += "<td>" + existencias + "</td>";
        let precioCompra = soluciones[i].producto.precioCompra;
        contenidoTC += "<td>" + precioCompra + "</td>";
        let precioVenta = soluciones[i].producto.precioVenta;
        contenidoTC += "<td>" + precioVenta + "</td>";
        let estatus = soluciones[i].producto.estatus;
        contenidoTC += "<td>" + estatus + "</td>";
       
        contenidoTC += "<td><button class='btn btn-info' onclick='cm.cargarSolucion(" + i + ");' >Detalle</button></td>";
        if (estatus===1) {
            contenidoTC+="<td><button class='btn btn-danger' onclick='cm.eliminarSoluciones();'>Eliminar</button></td>";
        }else{
            contenidoTC+="<td><button class='btn btn-success' onclick='cm.eliminarSoluciones();'>Activar</button></td>";
        }

        contenidoTC += "</tr>";
    }

    document.getElementById("tbodySoluciones").innerHTML = contenidoTC;
}

let soluciones;
let idProduc;
let idSolu;
let essstatus;

export function cargarSolucion(i) {

    document.getElementById("txtNombre").value = soluciones[i].producto.nombre;
    document.getElementById("txtMarca").value = soluciones[i].producto.marca;
    document.getElementById("txtExistencias").value = soluciones[i].producto.existencias;
    document.getElementById("txtPrecioCompra").value = soluciones[i].producto.precioCompra;
    document.getElementById("txtPrecioVenta").value = soluciones[i].producto.precioVenta;

    idProduc = soluciones[i].producto.idProducto;
    idSolu = soluciones[i].idSolucion;
    essstatus = soluciones[i].producto.estatus;

}
export function borrarSolucion(i) {

    document.getElementById("txtNombre").value = "";
    document.getElementById("txtMarca").value = "";
    document.getElementById("txtExistencias").value = "";
    document.getElementById("txtPrecioCompra").value = "";
    document.getElementById("txtPrecioVenta").value = "";

}

export function eliminarSoluciones() {

    if (essstatus === 1) {
        essstatus = 0;
    } else {
        essstatus = 1;
    }

    let producto = ({idProducto: idProduc, estatus: essstatus});
    let solucion = JSON.stringify({producto: producto});
    let parametros = new URLSearchParams({datos: solucion});

    fetch('../api/solucion/eliminarsolucion',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(JSON.stringify(data));
                } else {
                    Swal.fire('Solucion cambiada',
                            'con éxito',
                            'success'
                            );
                }

            });

}
export function modificarSolucion() {
    let nom = document.getElementById("txtNombre").value;
    let m = document.getElementById("txtMarca").value;
    let ex = document.getElementById("txtExistencias").value;
    let pc = document.getElementById("txtPrecioCompra").value;
    let pv = document.getElementById("txtPrecioVenta").value;

    let producto = ({idProducto: idProduc, nombre: nom, marca: m, existencias: ex, precioCompra: pc, precioVenta: pv});
    let solucion = JSON.stringify({idSolucion: idSolu, producto: producto});
    let parametros = new URLSearchParams({datos: solucion});

    fetch('../api/solucion/modificarsoluciones',
            {
                method: 'POST',
                body: parametros,
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                if (data.result) {
                    alert(JSON.stringify(data));
                } else {
                    Swal.fire('Solucion modificada',
                            'con éxito',
                            'success'
                            );
                }

            });

}
export function buscarSoluciones() {
    let buscar = document.getElementById("txtSearch").value;
    let parametros = {"buscar": buscar};

    fetch('../api/solucion/Buscar?buscar='+buscar)
            .then(response => response.json())
            .then(data => {
                cargarTablaSO(data);
                Swal.fire('Solucion encontrado',
                        'con éxito',
                        'success'
                        )

            });
} 