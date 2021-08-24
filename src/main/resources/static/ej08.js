$(document).ready(function () {
    refrescar();
    $("#cartera").click(verCartera);
});
function cargarDatos() {
    $.ajax({//tabla de inicio
        url: 'ejercicio8/listaCotizaciones',
        datatype: 'json',
        success: function (json) {
            $("#bolsa").html("");
            $("#bolsa").append("<thead><tr><th>Empresa</th><th>Útimo valor</th><th>Variación</th>" +
                    "<th>Porcentaje</th><th>Volumen</th><th>max</th><th>min</th><th>Hora</th><th>Comprar</th><th>Vender</th></tr></thead>");
            $.each(json, function (key, value) {
                var fila = $("<tr>");
                var titulo = value.titulo;
                var hora = value.hora;
                var precio = value.ultimo;
                var color = value.variacion > 0 ? "verde" : value.variacion < 0 ? "rojo" : "";
                var flecha = value.variacion > 0 ? "<i class='fas fa-sort-up'></i>" : value.variacion < 0 ? "<i class='fas fa-sort-down'></i>" : "";
                $("<td>").html(value.titulo + "</td>").appendTo(fila);
                $("<td>").html(value.ultimo + "</td>").appendTo(fila);
                $("<td>").attr("class", color).html(value.variacion + " " + flecha + "</td>").appendTo(fila);
                $("<td>").attr("class", color).html(value.variacionPorcentaje + "% " + flecha + "</td>").appendTo(fila);
                $("<td>").html(value.volumen + "</td>").appendTo(fila);
                $("<td>").html(value.maximo + "</td>").appendTo(fila);
                $("<td>").html(value.minimo + "</td>").appendTo(fila);
                $("<td>").html(value.hora + "</td>").appendTo(fila);
                $("<td>").html("<input type='button' value='Comprar' class='btn btn-primary' onClick='compra(`" + titulo + "`," + precio + ",`" + hora + "`);'/></td>").appendTo(fila);
                $("<td>").html("<input type='button' value='Vender' class='btn btn-danger' onClick='vender(`" + titulo + "`," + precio + ",`" + hora + "`,`comprar`);'/></td>").appendTo(fila);
                fila.append("</tr>");
                fila.appendTo("#bolsa");
            });
            $("#bolsa").append("</table>");
        }
    });
}
function refrescar() {
    cargarDatos();
    setInterval(function () {
        refrescar();
    }, 30000);//carga los datos cada 30 segundos
}
function compra(pTitulo, pPrecio) {
    $.post("/ejercicio8/formulario", {titulo: pTitulo,
        precio: pPrecio,
        operacion: 'Comprar'},
            function (pJson) {
                bootbox.dialog({
                    title: 'Comprar',
                    message: "<div id='formBB'>" + $('#formularioComprar').html() + "</div>"
                });
                $('#formBB form').deserialize(pJson);

            });
}
function vender(pTitulo, pPrecio) {
    $.post("/ejercicio8/venta", {titulo: pTitulo,
        precio: pPrecio,
        operacion: 'Vender'},
            function (pHtml) {
                bootbox.dialog({
                    title: 'Comprar',
                    message: pHtml
                });
            })
            .fail(function () {
                bootbox.alert("No tienes acciones de esta empresa")
            });
}
function verCartera() {//tabla con los datos de la base de datos
    $.ajax({
        url: 'ejercicio8/cartera',
        datatype: 'json',
        success: function (json) {
            $("#carteraTable").html("");
            $("#carteraTable").append("<thead><tr><th>Fecha de compra</th><th>Nombre empresa</th><th>Precio</th>" +
                    "<th>Numero de acciones</th><th>Tipo de operación</th></tr></thead><tbody>");
            $.each(json, function (key, value) {
                var fila = $("<tr>");
                $("<td>").html(value.hora + "</td>").appendTo(fila);
                $("<td>").html(value.titulo + "</td>").appendTo(fila);
                $("<td>").html(value.precio + "</td>").appendTo(fila);
                $("<td>").html(value.titulos + "</td>").appendTo(fila);
                $("<td>").html(value.operacion + "</td>").appendTo(fila);
                fila.append("</tr>");
                fila.appendTo("#carteraTable");
            });
            $("#carteraTable").append("</table>");
            bootbox.dialog({
                title: 'Comprar',
                size: 'xl',
                message: "<div id='carteraBB'>" + $('.carteraTable').html() + "</div>"
            });

        }
    });
}
