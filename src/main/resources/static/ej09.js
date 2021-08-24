$(document).ready(function () {
    $("#tag").click(tagF);
    $("#imagen").click(imagenF);
    $("#buscar").click(buscarB);
});
function tagF() {
    bootbox.dialog({
        title: 'Nueva etiqueta',
        message: $("#tagForm").html()
    });
}
function imagenF() {

    bootbox.dialog({
        title: 'Nueva imagen',
        message: $("#imgForm").html()
    });
}
function buscarB() {
    var dir = window.location.href;
    if (dir.includes("descripcion") && !dir.includes("categoria")) {
        window.location.href = window.location.href + " " + $("#barra").val();
    } else if (dir.includes("categoria") && !dir.includes("descripcion")) {
        window.location.href = window.location.href + "&descripcion=" + $("#barra").val();
    } else if (!dir.includes("categoria") && !dir.includes("descripcion")) {
        window.location.href = window.location.href + "?descripcion=" + $("#barra").val();
    } else {
        window.location.href = "/ejercicio9?descripcion=" + $("#barra").val();

    }

}
function buscarT(pEtiqueta) {
    var dir = window.location.href;
    if (dir.includes("categoria")) {
        window.location.href = "/ejercicio9?categoria=" + pEtiqueta;
    } else {
        if (dir.includes("descripcion")) {
            window.location.href = window.location.href + "&categoria=" + pEtiqueta;
        } else {
            window.location.href = window.location.href + "?categoria=" + pEtiqueta;
        }
    }
}

function filtrar(pFiltro) {
    var dir = window.location.href;
    if (dir.includes("filtro")) {
        window.location.href="/ejercicio9?filtro"+pFiltro;
    } else {
        window.location.href = window.location.href + "?filtro=" + pFiltro;
    }
    
}


