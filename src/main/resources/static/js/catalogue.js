$(function () {
  $(document).on("change", "#select-type", function () {
    const path = $(this).find(":selected").attr("href")
    //alert(path)
   /*  $.ajax({
    url: path,
    type: "GET",
    dataType: "JSON", // or html or whatever you want
    success: function (data) {
      console.log(data);
      console.log(path);
      window.location.href = data.url;
    },
    }); */
    window.location.href = path;
  });
});