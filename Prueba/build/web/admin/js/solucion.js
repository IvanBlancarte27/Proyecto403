function insertarSolucion() {
    let nom = document.getElementById("txtNombre").value;
    let m = document.getElementById("txtMarca").value;
    let ex = document.getElementById("txtExistencias").value;
    let pc = document.getElementById("txtPrecioCompra").value;
    let pv = document.getElementById("txtPrecioVenta").value;

    let producto = ({nombre: nom, marca: m, exitencias: ex, precioCompra: pc, precioVenta: pv});
    let solucion = JSON.stringify({producto: producto});
    let parametros = new URLSearchParams({datos: solucion});

    fetch('api/solucion/insertarsolucion',
            {
                method: 'POST',
                body: parametros,
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {

            });

}
function catalogoSoluciones() {
    let datos = {estatus: 1};
    let parametros = new URLSearchParams({datos});
    fetch('api/solucion/getAll',
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
function catalogoSolucionesInactivo() {
    let datos = {estatus: 0};
    let parametros = new URLSearchParams({datos});
    fetch('api/solucion/getAll2',
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
function cargarTablaSO(data) {
    soluciones = data;
    let contenidoTC = "";
    for (var i = 0; i < soluciones.length; i++) {
        contenidoTC += "<tr>";
        let nombre = soluciones[i].producto.nombre;
        contenidoTC += "<td>" + nombre + "</td>";
//        contenidoTE+="</tr>";
        let marca = soluciones[i].producto.marca;
        contenidoTC += "<td>" + marca + "</td>";
        let existencias = soluciones[i].producto.exitencias;
        contenidoTC += "<td>" + existencias + "</td>";
        let precioCompra = soluciones[i].producto.precioCompra;
        contenidoTC += "<td>" + precioCompra + "</td>";
        let precioVenta = soluciones[i].producto.precioVenta;
        contenidoTC += "<td>" + precioVenta + "</td>";
        let estatus = soluciones[i].producto.estatus;
        contenidoTC += "<td>" + estatus + "</td>";
        let codigoBarras = soluciones[i].producto.codigoBarras;
        contenidoTC += "<td>" + codigoBarras + "</td>";



        contenidoTC += "<td><button onclick='cargarSolucion(" + i + ");' >ver</button></td>";
        contenidoTC += "<td><button onclick='eliminarSoluciones();'>elimnar-activar</button></td>";


        contenidoTC += "</tr>";
    }

    document.getElementById("tblSoluciones").innerHTML = contenidoTC;
}

function cargarSolucion(i) {

    document.getElementById("txtNombre").value = soluciones[i].producto.nombre;
    document.getElementById("txtMarca").value = soluciones[i].producto.marca;
    document.getElementById("txtExistencias").value = soluciones[i].producto.exitencias;
    document.getElementById("txtPrecioCompra").value = soluciones[i].producto.precioCompra;
    document.getElementById("txtPrecioVenta").value = soluciones[i].producto.precioVenta;

    idProduc = soluciones[i].producto.idProducto;
    idSolu = soluciones[i].idSolucion;
    essstatus = soluciones[i].producto.estatus;

}
function borrarSolucion(i) {

    document.getElementById("txtNombre").value = "";
    document.getElementById("txtMarca").value = "";
    document.getElementById("txtExistencias").value = "";
    document.getElementById("txtPrecioCompra").value = "";
    document.getElementById("txtPrecioVenta").value = "";

}
let soluciones;
let idProduc;
let idSolu;
let essstatus;
function eliminarSoluciones() {

    if (essstatus === 1) {
        essstatus = 0;
    } else {
        essstatus = 1;
    }

    let producto = ({idProducto: idProduc, estatus: essstatus});
    let solucion = JSON.stringify({producto: producto, idProducto: idProduc});
    let parametros = new URLSearchParams({datos: solucion});

    fetch('api/solucion/eliminarsolucion',
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
function modificarSolucion() {
    let nom = document.getElementById("txtNombre").value;
    let m = document.getElementById("txtMarca").value;
    let ex = document.getElementById("txtExistencias").value;
    let pc = document.getElementById("txtPrecioCompra").value;
    let pv = document.getElementById("txtPrecioVenta").value;

    let producto = ({idProducto: idProduc, nombre: nom, marca: m, exitencias: ex, precioCompra: pc, precioVenta: pv});
    let solucion = JSON.stringify({idSolucion: idSolu, producto: producto});
    let parametros = new URLSearchParams({datos: solucion});

    fetch('api/solucion/modificarsoluciones',
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
function buscarSoluciones() {
    let buscar = document.getElementById("buscar").value;
    let parametros = {"buscar": buscar};

    fetch('api/solucion/Buscar?buscar=' + buscar)
            .then(response => response.json())
            .then(data => {
                cargarTablaSO(data);
                Swal.fire('Solucion encontrado',
                        'con éxito',
                        'success'
                        )

            });
} 