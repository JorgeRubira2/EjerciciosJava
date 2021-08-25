$(document).ready(function () {
    $("#tag").click(tagF);
    $("#imagen").click(imagenF);
    $("#buscar").click(buscarB);
    $("#aparecer a").click(aparecerDesaparecer);
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
    if (dir.includes("?descripcion") && (!dir.includes("categoria") || !dir.includes("filtro"))) {
        window.location.href = window.location.href + " " + $("#barra").val();
    } else if (dir.includes("?") && !dir.includes("descripcion")) {
        window.location.href = window.location.href + "&descripcion=" + $("#barra").val();
    } else if (!dir.includes("?")) {
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
        if (dir.includes("?")) {
            window.location.href = window.location.href + "&categoria=" + pEtiqueta;
        } else {
            window.location.href = window.location.href + "?categoria=" + pEtiqueta;
        }
    }
}

function filtrar(pFiltro) {
    var dir = window.location.href;
    if (dir.includes("filtro")) {
        window.location.href = "/ejercicio9?filtro" + pFiltro;
    } else if (dir.includes("?")) {
        window.location.href = window.location.href + "&filtro=" + pFiltro;
    } else {
        window.location.href = window.location.href + "?filtro=" + pFiltro;
    }

}

function aparecerDesaparecer() {
    if ($(this).html().includes("right")) {
        $(this).html('Filtros &nbsp;<i class="fas fa-caret-square-left"></i>');
    } else {
        $(this).html('Filtros &nbsp;<i class="fas fa-caret-square-right"></i>');
    }
    $("#filtros").toggle();
}

function ampliar(pUrl){
    bootbox.alert({
        size:'xl',
       message:"<div style='text-align:center'><img src='"+pUrl+"'/></div>" 
    });
}
