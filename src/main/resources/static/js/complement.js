 const form = document.querySelector("form");
 const image = document.getElementById("image");
 const quantite = document.getElementById("quantite");
 const taille = document.getElementById("taille");
 const marque = document.getElementById("marque");
 const type = document.getElementById("type");
 
 
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
   if (type.value === "boisson") {
    
   } else if (type.value === "frite" ) {
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
   checkRequired([image,quantite,taille,marque,type]);
   //checkLength(nom,3,30);
 /* 
   if (type.value === 'menu') {
     checkRequired([burger]);
     
       checkRequired([complement]);
     
   }
 
   if (type.value === 'burger' || type.value === 'complement') {
     checkRequired([prix]);
     CheckNumberMatch(prix);
     checkLength(prix , 3 , 6);
   }
    */
 
   
   //console.log(isValid); 
   for (let i = 0; i < isValid.length; i++) {
     if (isValid[i] == false) {
       e.preventDefault();
     }
   }
 
   /* for (let i = 0; i < isValid.length; i++) {
     if (isValid[i] == true) {
       this.submit();
     }
   } */
   
 
   //  var str = checkNameStringMatch(nomPavillon);
   //  var lg = checkLength(nomPavillon,4,20);
 
   //document.getElementById('button').onsubmit();
 
   /* if (!str) {
          e.preventDefault(); 
     }
     if (!lg) {
      e.preventDefault();   
     }
     if (!nb) {
      e.preventDefault();   
     } */
   //
 
   /*   function isValidnbrEtage(nbrEtage) {//Tester si l'nbrEtage est valide
      const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      return re.test(String(nbrEtage).toLowerCase());
  }
      if (nomPavillon.value === '') {
         showError(nomPavillon,'nomPavillon is required!'); 
      }else{
          showSuccess(nomPavillon);
      }
  
      if (nbrEtage.value === '') {
         showError(nbrEtage,'nbrEtage is required!'); 
      }else if(!isValidnbrEtage(nbrEtage.value)){
          showError(nbrEtage,'nbrEtage is not valid!');
      }else{
          showSuccess(nbrEtage);
      } */
 
   /*   if (password.value === '') {
         showError(password,'password is required!'); 
      }else{
          showSuccess(password);
      }
  
      if (password2.value === '') {
         showError(password2,'Password 2 is required!'); 
      }else{
          showSuccess(password2);
      } */
 });
 