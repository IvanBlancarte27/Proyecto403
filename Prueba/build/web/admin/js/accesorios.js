let accesorios;
export function insertarAccesorio() {
    
    let nombreAc=document.getElementById("txtNombreAcc").value;
    let marcaAc =document.getElementById("txtMarcaAcc").value;
    let precioCompraAc = document.getElementById("txtPrecioComAcc").value;
    let precioVentaAc= document.getElementById("txtPrecioVenAcc").value;
    let existenciaAc= document.getElementById("txtExistenciaAcc").value;
    
    let producto={nombre:nombreAc,
                  marca:marcaAc,
                  precioCompra:precioCompraAc,
                  precioVenta:precioVentaAc,
                  existencias:existenciaAc};
              
    let accesorio=JSON.stringify({producto:producto});
    
    let parametros=new URLSearchParams({datos:accesorio});
    
        fetch('../api/Accesorios/insertar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                let msj ="Accesorio insertado con ID"+data.idAccesorio; 
                alert(JSON.stringify(data));
                //alert(msj);
            });
}

//Esta funcion nos muestra los Accesorios Activos En la tabla
export function catalagoAccesoriosAct() {
    let datos={estatus:1};
    let parametros = new URLSearchParams({datos});
    
        fetch('../api/Accesorios/getAllAc',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error!=null) {
                    alert(JSON.stringify(data));
                }else{
                    cargarTableAccesorios(data);
                }
            });
    
}

export function catalagoAccesoriosInact() {
    let datos={estatus:0};
    let parametros = new URLSearchParams({datos});
    
        fetch('../api/Accesorios/getAllInactivos',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error!=null) {
                    alert(JSON.stringify(data));
                }else{
                    cargarTableAccesorios(data);
                }
            });
    
}
;
export function  cargarTableAccesorios(data) {
    accesorios=data;
    let contenidoTablaAccesorios="";
    for (var i = 0; i <accesorios.length; i++) {
        contenidoTablaAccesorios+="<tr>";
        let nombre=accesorios[i].producto.nombre;
        contenidoTablaAccesorios+="<td>"+nombre+"</td>";
        let marca=accesorios[i].producto.marca;
        contenidoTablaAccesorios+="<td>"+marca+"</td>";
        let precioC=accesorios[i].producto.precioCompra;
        contenidoTablaAccesorios+="<td>"+precioC+"</td>";
        let precioV=accesorios[i].producto.precioVenta;
        contenidoTablaAccesorios+="<td>"+precioV+"</td>";
        let existencias=accesorios[i].producto.existencias;
        contenidoTablaAccesorios+="<td>"+existencias+"</td>";
        let estatus=accesorios[i].producto.estatus;
        contenidoTablaAccesorios+="<td>"+estatus+"</td>";
        
        contenidoTablaAccesorios+="<td><button class='btn btn-info' onclick='cm.cargarFrmAccesorios("+i+");'>Mostrar</button></td>";
        if (estatus===1) {
            contenidoTablaAccesorios+="<td><button class='btn btn-danger' onclick='cm.eliminarAccesorio();'>Eliminar</button></td>";
        }else{
            contenidoTablaAccesorios+="<td><button class='btn btn-success' onclick='cm.eliminarAccesorio();'>Activar</button></td>";
        }
        
        contenidoTablaAccesorios+="</tr>";
    }
    
    document.getElementById("tbodyAccesorios").innerHTML=contenidoTablaAccesorios;
}
let status;
let idProdc;
let idAcc;


export function cargarFrmAccesorios(i) {
    
    document.getElementById("txtNombreAcc").value=accesorios[i].producto.nombre;
    document.getElementById("txtMarcaAcc").value=accesorios[i].producto.marca;
    document.getElementById("txtPrecioComAcc").value=accesorios[i].producto.precioCompra;
    document.getElementById("txtPrecioVenAcc").value=accesorios[i].producto.precioVenta;
    document.getElementById("txtExistenciaAcc").value=accesorios[i].producto.existencias;
    
    idProdc=accesorios[i].producto.idProducto;
    idAcc= accesorios[i].idAccesorio;
    status=accesorios[i].producto.estatus;
    
    //alert("Estatus"+" "+status+" "+"Id Producto"+" "+idProdc+""+"Id Accesorio"+idAcc);
   
}

export function limpiar() {
    document.getElementById("txtNombreAcc").value="";
    document.getElementById("txtMarcaAcc").value="";
    document.getElementById("txtPrecioComAcc").value="";
    document.getElementById("txtPrecioVenAcc").value="";
    document.getElementById("txtExistenciaAcc").value="";
}


export function modificarAccesorio() {
    
    let nombreAc=document.getElementById("txtNombreAcc").value;
    let marcaAc =document.getElementById("txtMarcaAcc").value;
    let precioCompraAc = document.getElementById("txtPrecioComAcc").value;
    let precioVentaAc= document.getElementById("txtPrecioVenAcc").value;
    let existenciaAc= document.getElementById("txtExistenciaAcc").value;
    
    let producto={idProducto:idProdc,
                  nombre:nombreAc,
                  marca:marcaAc,
                  precioCompra:precioCompraAc,
                  precioVenta:precioVentaAc,
                  existencias:existenciaAc};
              
    let accesorio=JSON.stringify({idAccesorio:idAcc,producto:producto});
    
    let parametros=new URLSearchParams({datos:accesorio});
    
        fetch('../api/Accesorios/Actualizar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                 
                let msj ="Accesorio Actualizado"; 
                alert(JSON.stringify(data));
                //alert(msj);
            });
}

export function eliminarAccesorio() {
    if (status===1) {
        status=0;
    }else{
        status=1;
    }
    
     let producto =({idProducto:idProdc,estatus:status});
     let accesorio=JSON.stringify({producto:producto,idAccesorio:idAcc});
     let parametros = new URLSearchParams({datos:accesorio});
      fetch('../api/Accesorios/eliminar',
            {
                method: 'POST',
                body:(parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
              .then(data => {
                alert(JSON.stringify(data));
            });
}

export function buscarAccesorio() {
    let busqueda=document.getElementById("txtSearch").value;
    let parametros={"buscar":busqueda};
    
    fetch('../api/Accesorios/buscar?busqueda='+busqueda)
            .then(response => response.json())
            .then(data => {
                cargarTableAccesorios(data);
                alert(JSON.stringify(data));
            });
    
}