 // form 1 boisson
 const form = document.querySelector("form");
 const image = document.getElementById("image");
 const prix = document.getElementById("prix");
 const description = document.getElementById("description");
 const nom = document.getElementById("nom");
 const type = document.getElementById("type");
 //
 //form  2 frite

/*  const form2 = document.getElementById("form2")
 const imageFrite = document.getElementById("imageF");
 const quantiteFrite = document.getElementById("quantiteF");
 const prix = document.getElementById("prix");
 const libelle = document.getElementById("libelle");
 const type2 = document.getElementById("type2"); */
 
 //
 
 //filter ajax
 
 
 //
 
 let isValid = [];
 //Functions-------------------------------------------------------------
 function showError(input, message) {
   //Afficher les messages d'erreur
   const formControl = input;
   const formControlPa = input.parentElement;
   formControl.className = "form-control is-invalid";
   const small = formControlPa.querySelector("div");
   small.innerText = message;
   isValid.push(false);
 }
 //
 function showSuccess(input) {
   const formControl = input;
   formControl.className = "form-control is-valid";
   isValid.push(true);
 }
 //
 /* function checknbrEtage(input) {//Tester si l'nbrEtage est valide :  javascript : valid nbrEtage
      const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  
      if (re.test(input.value.trim().toLowerCase())) {
          showSuccess(input);
      } else {
          showError(input,`nbrEtage is not valid!`);
      }
  } */
 //
 function checkRequired(inputArray) {
   // Tester si les champs ne sont pas vides
   var bool = false;
   inputArray.forEach((input) => {
     if (input.value.trim() === "") {
       showError(input, `ce champs est obligatoire`);
     } else if (input.value === "0") {
       showError(input, `ce champs est obligatoire`);
     } else {
       showSuccess(input);
     }
   });
 }
 //
 function getFieldName(input) {
   //Retour le nom de chaque input en se basant sur son id
   return input.id.charAt(0).toUpperCase() + input.id.slice(1);
 }
 //
 function checkLength(input, min, max) {
   //Tester la longueur de la valeur  d'un input
   if (input.value.length < min) {
     showError(
       input,
       `${getFieldName(input)} doit contenir au moins ${min} caractéres!`
     );
   } else if (input.value.length > max) {
     showError(
       input,
       `${getFieldName(input)} ne doit contenir au plus ${max} caractéres !`
     );
     console.log(input.value.length);
   } else {
     showSuccess(input);
   }
 }
 //
 function checkNameStringMatch(input) {
   const regex = "^[A-Za-z]{1,20}, [A-Za-z]{1,20}, [A-Za-z]{1,20}";
   var bool = true;
   if (regex.test(input.value.trim())) {
     showSuccess(input);
   } else {
     showError(input, "le nom est invalide!!");
     bool = false;
   }
   return bool;
 }
 function CheckNumberMatch(input) {
   const rg = /^[0-9]+$/;
   var bool = false;
   if (input.value.trim() === "") {
     showError(input, "Champs obligatoire!!");
   } else if (!rg.test(input.value.trim())) {
     showError(input, "Veillez saisir des entiers !!");
   } else {
     showSuccess(input);
   }
 }
 //
 function checkPasswordMatch(input1, input2) {
   if (input1.value !== input2.value) {
     showError(input2, "Passwords do not match!");
   }
 }
 
 function handleClick(type) {
   if (type.value === "burger") {
    document.getElementById("form2").style.display = "none";
    document.getElementById("form").style.display = "block";
   } else if (type.value === "menu" ) {
     document.getElementById("form2").style.display = "block";
     document.getElementById("form").style.display = "none";
   }/*  else if (type.value === "complement") {
     document.getElementById("menuAdd").style.display = "none";
     document.getElementById("prix_champs").style.display = "block";
   } */
 }
 
 
 //Even listeners--------------------------------------------------------
 //type.addEventListener("click", handleClick(type));
 form.addEventListener("submit", function (e) {
  
   // var nb = CheckNumberMatch(nbrEtage);
  // e.preventDefault();
   
   isValid = [];
   checkRequired([image,prix,description,nom]);
  
   
   //console.log(isValid); 
   for (let i = 0; i < isValid.length; i++) {
     if (isValid[i] == false) {
       e.preventDefault();
     }
   }
 
  
 });
 

 /* form2.addEventListener("submit", function (e) {
  // var nb = CheckNumberMatch(nbrEtage);
  e.preventDefault();
  
  isValid = [];
  checkRequired([imageFrite,quantiteFrite,prix,libelle,type2]);
 
  
  //console.log(isValid); 
  for (let i = 0; i < isValid.length; i++) {
    if (isValid[i] == false) {
      e.preventDefault();
    }
  }

 
}); */