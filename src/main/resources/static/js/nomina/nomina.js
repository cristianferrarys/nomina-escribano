$(document).ready(function() {

  $('.cuil').mask('99-99999999-9');

  $('#btn-buscar').click(function(e) {
    e.preventDefault();
    var cuil = $('.cuil').val().replaceAll("-", "");
    if (cuil !== "" && cuil.length == 11) {
      $('#cuil').val(cuil);
      $('#form').submit();
    }
    swal({
      title:'El Cuit Invalido',
      text:"La cantidad minina es de 11 digitos",
      type:'warning',
      showConfirmButton: false,
      timer: 3000
    })
  });

});