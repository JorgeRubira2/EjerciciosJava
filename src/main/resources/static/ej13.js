$(document).ready(function () {
    $("#elegirFactura").change(cambiar);

});
function lineaN() {
    bootbox.dialog({
        title: 'Nueva Linea',
        size: 'large',
        message: $("#nuevaLinea").html()
    });
}
function borrar(pID) {
    bootbox.confirm({
        size: 'small',
        message: '¿Estás seguro de borrar el registro?',
        callback: function (result) {
            if (result) {
                window.location.href = "/ej13/borrar?id=" + pID;
            }
        }
    });
}
function editar() {
    $(".encaEditable").removeAttr("disabled");
}
function cambiar() {

    window.location.href = "/ej13?id_encabezado=" + $(this).val();
}
function editarLinea(idLinea, idEncabezado) {

    $.post("/ej13/editarLinea", {
        id: idLinea,
        idEncabezado: idEncabezado
    }, function (pJson) {
        bootbox.dialog({
            title: 'Editar linea',
            message: "<div id='formBB'>" + $('#nuevaLinea').html() + "</div>"
        });
        $('#formBB form').deserialize(pJson);
    });
}
function borrarLinea(idLinea, idEncabezado) {
    bootbox.confirm({
        size: 'small',
        message: '¿Estás seguro de borrar la línea?',
        callback: function (result) {
            if (result) {
                window.location.href = "/ej13/borrarLinea?id=" + idLinea + "&idEncabezado=" + idEncabezado;
            }
        }
    });
}

