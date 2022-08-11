const select = document.querySelector("#select-type");
select.addEventListener("change", function (event) {
   
  console.log("true");
  const option = event.target.options[select.selectedIndex];
//  const path = "http://localhost:8080/catalogue/type/"+select.value;
  const path =  option.getAttribute('href');
 //alert(path);
  fetch(path, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
    
  })
    .then((response) => {
     //let promesse =  response.json();
     console.log(response.json());
   //  window.location.href = promesse.url;
    })
    .catch((err) => console.log(err));
});
