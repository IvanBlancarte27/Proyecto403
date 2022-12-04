let lentes;

export function insertarLentesContacto() {
    let nombre = document.getElementById("txtNombreLC").value;
    let marca = document.getElementById("txtMarcaLC").value;
    let precioCom = document.getElementById("txtPrecioCompraLC").value;
    let precioVen = document.getElementById("txtPrecioVentaLC").value;
    let existencias = document.getElementById("txtExistenciasLC").value;
    let imagen = document.getElementById("imgLenteLC").value;
    let keratom = document.getElementById("txtkeratometriaLC").value;

    let producto = {nombre: nombre,
        marca: marca,
        precioCompra: precioCom,
        precioVenta: precioVen,
        existencias: existencias};
    let lente = JSON.stringify({producto: producto,
        keratometria: keratom,
        fotografia: imagen});

    let parametros = new URLSearchParams({datos: lente});

    fetch('../api/lentesC/insertarLente',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                //let msj = "Lente Insertado con ID" + data.idAccesorio;
                //alert(JSON.stringify(data));
                //alert(msj);
                if (data.error)
                    alert(JSON.stringify(data));
                else
                    mandarConfirmacionGuardar();
            });

}

export function catalagoLentesContactoAct() {
    let datos = {estatus: 1};
    let parametros = new URLSearchParams({datos});

    fetch('../api/lentesC/getAllActivos',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(JSON.stringify(data));
                } else {
                    cargarTableLentesContacto(data);
                }
            });
}

export function catalagoLentesContactoInac() {
    let datos = {estatus: 0};
    let parametros = new URLSearchParams({datos});

    fetch('../api/lentesC/getAllInactivos',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(JSON.stringify(data));
                } else {
                    cargarTableLentesContacto(data);
                }
            });
}

let idProduct;
let idLente;
let status;
export function cargarTableLentesContacto(data) {
    lentes = data;
    let contenidoTablaLentes = "";

    for (var i = 0; i < lentes.length; i++) {
        contenidoTablaLentes += "<tr>";
        let nombre = lentes[i].producto.nombre;
        contenidoTablaLentes += "<td>" + nombre + "</td>";
        let marca = lentes[i].producto.marca;
        contenidoTablaLentes += "<td>" + marca + "</td>";
        let precioC = lentes[i].producto.precioCompra;
        contenidoTablaLentes += "<td>" + precioC + "</td>";
        let precioV = lentes[i].producto.precioVenta;
        contenidoTablaLentes += "<td>" + precioV + "</td>";
        let existencias = lentes[i].producto.existencias;
        contenidoTablaLentes += "<td>" + existencias + "</td>";
        let kerato = lentes[i].keratometria;
        contenidoTablaLentes += "<td>" + kerato + "</td>";

        let foto = lentes[i].fotografia;
        let codigo = lentes[i].producto.codigoBarras;

        let estatus = lentes[i].producto.estatus;
        contenidoTablaLentes += "<td>" + estatus + "</td>";
        contenidoTablaLentes += "<td><button class='btn btn-info' onclick='cm.cargarFrmLentes(" + i + ");'>Mostrar</button></td>";
        if (estatus === 1) {
            contenidoTablaLentes += "<td><button class='btn btn-danger' onclick='cm.eliminarLentes();'>Eliminar</button></td>";
        } else {
            contenidoTablaLentes += "<td><button class='btn btn-success' onclick='cm.eliminarLentes();'>Activar</button></td>";
        }

        contenidoTablaLentes += "</tr>";
    }
    document.getElementById("tbodyLentesC").innerHTML = contenidoTablaLentes;
}

export function cargarFrmLentes(i) {
    
    document.getElementById("txtNombreLC").value = lentes[i].producto.nombre;
    document.getElementById("txtMarcaLC").value = lentes[i].producto.marca;
    document.getElementById("txtPrecioCompraLC").value = lentes[i].producto.precioCompra;
    document.getElementById("txtPrecioVentaLC").value = lentes[i].producto.precioVenta;
    document.getElementById("txtExistenciasLC").value = lentes[i].producto.existencias;
    document.getElementById("imgLenteLC").value = lentes[i].fotografia;
    document.getElementById("txtkeratometriaLC").value = lentes[i].keratometria;
    document.getElementById("txtCodigoBarrasL").value = lentes[i].producto.codigoBarras;

    idProduct = lentes[i].producto.idProducto;
    idLente = lentes[i].idLenteContacto;
    status = lentes[i].producto.estatus;
    
    // alert("Estatus"+" "+status+" "+"Id Producto"+" "+idProduct+""+"Id lente"+idLente);

}

export function limpiarFormulario() {
    document.getElementById("txtNombreLC").value = "";
    document.getElementById("txtMarcaLC").value = "";
    document.getElementById("txtPrecioCompraLC").value = "";
    document.getElementById("txtPrecioVentaLC").value = "";
    document.getElementById("txtExistenciasLC").value = "";
    document.getElementById("imgLenteLC").value = "";
    document.getElementById("txtkeratometriaLC").value = "";
    document.getElementById("txtCodigoBarrasL").value = "";
}

export function modificarLentes() {
    let nombre = document.getElementById("txtNombreLC").value;
    let marca = document.getElementById("txtMarcaLC").value;
    let precioCom = document.getElementById("txtPrecioCompraLC").value;
    let precioVen = document.getElementById("txtPrecioVentaLC").value;
    let existencias = document.getElementById("txtExistenciasLC").value;
    let imagen = document.getElementById("imgLenteLC").value;
    let keratom = document.getElementById("txtkeratometriaLC").value;

    let producto = {idProducto: idProduct,
        nombre: nombre,
        marca: marca,
        precioCompra: precioCom,
        precioVenta: precioVen,
        existencias: existencias};
    let lente = JSON.stringify({producto: producto,
        idLenteContacto: idLente,
        keratometria: keratom,
        fotografia: imagen});

    let parametros = new URLSearchParams({datos: lente});

    fetch('../api/lentesC/actualizarLentes',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                //let msj = "Lente Insertado con ID" + data.idAccesorio;
                //alert(JSON.stringify(data));
                //alert(msj);
                if (data.error)
                    alert(JSON.stringify(data));
                else
                    mandarConfirmacionActualizar();
            });
}

export function eliminarLentes() {

    if (status === 1) {
        status = 0;
    } else {
        status = 1;
    }

    let producto = ({idProducto:idProduct,estatus:status});
    let lentes = JSON.stringify({producto: producto,idLenteContacto:idLente});
    let parametros = new URLSearchParams({datos:lentes});

    fetch('../api/lentesC/eliminar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                //alert(JSON.stringify(data));
                    
                if (data.erro){
                    alert(JSON.stringify(data));
                }else{
                        mandarConfirmacionEliminar();                   
                }
                    
            });
}

export function buscarLentes() {
    let busqueda = document.getElementById("txtSearch").value;
    let parametros = {"buscar": busqueda};

    fetch('../api/lentesC/buscar?busqueda=' + busqueda)
            .then(response => response.json())
            .then(data => {
                cargarTableLentesContacto(data);
                //alert(JSON.stringify(data));
            });

}




