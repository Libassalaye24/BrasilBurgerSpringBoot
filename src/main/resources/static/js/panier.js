
let panier = [];

if (localStorage.getItem("panier")) {
  panier = JSON.parse(localStorage.getItem("panier"));
}
function checkFood(id){
  panier.forEach(element => {
    if (element.id == id)  {
        return true;
    }else{
      return false;
    }
  });
}
function addInPanier(food)
{
  const check = panier.find(product => product.id === food.id);
  let numberClick = 0;
  if (check == undefined) {
    food.quantity = 1;
    panier.push(
      food
     );
  }else{
    check.quantity = check.quantity + 1;
  }
  
 // console.log(check);

  console.log(panier);

  localStorage.setItem("panier", JSON.stringify(panier));
  localStorage.setItem("count" , panier.length);
}
function removeInPanier(food , index) {
  const check = panier.find(product => product.id === food.id);
 
  if (check.quantity > 1) {
    check.quantity = check.quantity - 1;
  }else if(check.quantity == 1){
      panier.splice(index , 1);
  }
  localStorage.setItem("panier", JSON.stringify(panier));
  localStorage.setItem("count" , panier.length);
}
function deleteInPanier(index ) {
 
  panier.splice(index , 1);
  
  localStorage.setItem("panier", JSON.stringify(panier));
  localStorage.setItem("count" , panier.length);
}
const panierContainer = document.getElementById("panier-container");
const subtotal= document.getElementById("subtotal");
const alltotal= document.getElementById("total");
if (alltotal) {
  alltotal.style.color = "#FFF";
}
if (subtotal) {
  subtotal.style.color = "#FFF";
}
let total = 0;
function showPanier(params) {
    let listPanier = [];
    listPanier = JSON.parse(localStorage.getItem("panier"));

    Array(listPanier).forEach(element => {
        element.forEach((e ,index) => {
            const box = document.createElement("div");
            box.classList.add("box");

            const a_remove = document.createElement("a");
            a_remove.classList.add("a-remove");
            const fas_remove = document.createElement("i");
            fas_remove.classList.add("fas");
            fas_remove.classList.add("fa-times");
            a_remove.appendChild(fas_remove);

            const img = document.createElement("img");
            img.src="img/foods/"+e.image;

            const h3 = document.createElement("h3");
            h3.innerHTML = `${e.nom}`;

            const spanQuantite = document.createElement("span");
            spanQuantite.innerHTML = "quantite : ";

            const a_minus = document.createElement("a");
            a_minus.classList.add("btn-panier");
            const fas_aMinus = document.createElement("i");
            fas_aMinus.classList.add("fas");
            fas_aMinus.classList.add("fa-minus");
            a_minus.appendChild(fas_aMinus);

            const spanNumber = document.createElement("span");
            spanNumber.classList.add("number");
            spanNumber.innerHTML = ` ${e.quantity} `;

            const a_plus = document.createElement("a");
            a_plus.classList.add("btn-panier");
            const fas_aPlus = document.createElement("i");
            fas_aPlus.classList.add("fas");
            fas_aPlus.classList.add("fa-plus");
            a_plus.appendChild(fas_aPlus);

            a_plus.addEventListener("click" , function () {
                addInPanier(e);
                location.reload();
            });

            a_minus.addEventListener("click" , function () {
              removeInPanier(e ,index);
              location.reload();
            });

            a_remove.addEventListener("click" , function () {
              deleteInPanier(index);
              location.reload();
            });

            const br = document.createElement("br");

            const span = document.createElement("span");
            span.innerHTML = "prix unitaire: ";
           
            const spanPrice = document.createElement("span");
            spanPrice.classList.add("price");
            spanPrice.innerHTML = `${e.prix} fcfa`;

            const br2 = document.createElement("br");

            const span2p = document.createElement("span");
            span2p.innerHTML = "prix total : ";
           
            const spanPrice2 = document.createElement("span");
            spanPrice2.classList.add("price");
            spanPrice2.innerHTML = `${e.prix * e.quantity} fcfa`;

            const contentDiv = document.createElement("div");
            contentDiv.classList.add("content");

            contentDiv.appendChild(h3);
            contentDiv.appendChild(spanQuantite);
            contentDiv.appendChild(a_minus);
            contentDiv.appendChild(spanNumber);
            contentDiv.appendChild(a_plus);
            contentDiv.appendChild(br);
            contentDiv.appendChild(span);
            contentDiv.appendChild(spanPrice);
            contentDiv.appendChild(br2);
            contentDiv.appendChild(span2p);
            contentDiv.appendChild(spanPrice2);

            box.appendChild(a_remove);
            box.appendChild(img);
            box.appendChild(contentDiv);
            total += e.prix * e.quantity;
            if (alltotal && subtotal) {
              alltotal.innerHTML = total + " FCFA";
              subtotal.innerHTML = total + " FCFA";
            }
            panierContainer.appendChild(box);
        })
    });
}

if (panierContainer) {
  
showPanier();
}