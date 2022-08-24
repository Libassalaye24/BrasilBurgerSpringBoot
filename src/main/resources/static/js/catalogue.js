


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
const foodContainer = document.getElementById("food-container");
async function showFoods() {
  const post = await getFoods();

  Array(post.burgers).forEach((element) => {
    element.forEach((food) => {
      //div class box
      const box = document.createElement("div");
      box.classList.add("box");
      box.setAttribute("data-aos" ,"fade-up" );
      box.setAttribute("data-aos-duration" ,"3000" );
      
      //
      //div class image
      const imageDiv = document.createElement("div");
      imageDiv.classList.add("image");
      const image = document.createElement("img");
      image.src = `img/foods/${food.image}`;
      image.classList.add("animate__backInUp");
      imageDiv.appendChild(image);
      //
      //div class content
      const contentDiv = document.createElement("div");
      contentDiv.classList.add("content");
      //h3 for name food
      const h3 = document.createElement("h3");
      h3.innerHTML = `${food.nom}`;
      //
      //stars class
      const stars = document.createElement("div");
      stars.classList.add("stars");
      const star1 = document.createElement("i");
      star1.classList.add("fas");
      star1.classList.add("fa-star");
      const star2 = document.createElement("i");
      star2.classList.add("fas");
      star2.classList.add("fa-star");
      const star3 = document.createElement("i");
      star3.classList.add("fas");
      star3.classList.add("fa-star");
      const star4 = document.createElement("i");
      star4.classList.add("fas");
      star4.classList.add("fa-star");
      const star5 = document.createElement("i");
      star5.classList.add("fas");
      star5.classList.add("fa-star-half-alt");
      const spanC = document.createElement("span");
      spanC.innerHTML = "(50)";
      stars.appendChild(star1);
      stars.appendChild(star2);
      stars.appendChild(star3);
      stars.appendChild(star4);
      stars.appendChild(star5);
      stars.appendChild(spanC);
      //
      const price = document.createElement("div");
      price.classList.add("price");
      price.innerHTML += `${food.prix} FCFA`;
      const linkDetails = document.createElement("a");
      linkDetails.href = `catalogue/details/${food.id}`;
      linkDetails.classList.add("btn");
      linkDetails.innerHTML += "Voir Details";
      const linkAdd = document.createElement("a");
      linkAdd.classList.add("btn");
      linkAdd.classList.add("add-panier");

      const iconShop = document.createElement("i");
      iconShop.classList.add("fa-solid");
      iconShop.classList.add("fa-cart-plus");
      linkAdd.appendChild(iconShop);
      linkAdd.innerHTML += "Ajouter";
      const spave = " ";
      contentDiv.appendChild(h3);
      contentDiv.appendChild(stars);
      contentDiv.appendChild(price);
      contentDiv.appendChild(linkDetails);
  //    contentDiv.appendChild(spave);
      contentDiv.appendChild(linkAdd);

      box.appendChild(imageDiv);
      box.appendChild(contentDiv);
      //

      foodContainer.appendChild(box);

      //events
      linkAdd.addEventListener("click" , ()=>{
        
        addInPanier(food);
        Swal.fire({
          position: "top-end",
          icon: "success",
          title: "Produit ajouté avec succés",
          background: "#000",
          color: "#fff",
          showConfirmButton: true,
        });
        document.querySelector(".swal2-confirm").style.background = "#FFD800";
        document.querySelector(".swal2-confirm").style.color = "#000";

        document.querySelector(".swal2-confirm").addEventListener("click" , function () {
            location.reload();
            
        })
      //  
      })
    });
  });
}

const url2 = "/catalogue/burger";

async function getFoods() {
  let post;
  await fetch(url2)
    //.then(resp=> console.log(resp))
    .then((resp) => resp.json())
    .then((data) => {
      post = data;
      console.log(data);
    });
  return post;
}
showFoods();



const panierContainer = document.getElementById("panier-container");
const subtotal= document.getElementById("subtotal");
const alltotal= document.getElementById("total");
/* alltotal.style.color = "#FFF";
subtotal.style.color = "#FFF"; */
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
            alltotal.innerHTML = total + " FCFA";
            subtotal.innerHTML = total + " FCFA";
            panierContainer.appendChild(box);
        })
    });
}


showPanier();


