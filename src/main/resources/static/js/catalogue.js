
const buttonAddPanier = document.querySelectorAll("[addPanier2]");

for (const food of buttonAddPanier) {
  food.addEventListener("click", function () {
    let post;
    let url = "/catalogue/";
    let type = food.getAttribute("data-type");
    let id = food.getAttribute("data-id");
    if (type === "menu") {
      url += "menu/" + id;
    } else {
      url += "burger/" + id;
    }
    fetch(url)
      //.then(resp=> console.log(resp))
      .then((resp) => resp.json())
      .then((data) => {
        post = data;
        if (type === "burger") {
          addInPanier(post.burger);
        } else {
          addInPanier(post.menu);
        }
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

        document
          .querySelector(".swal2-confirm")
          .addEventListener("click", function () {
            location.reload();
          });
      });
  });
}
/* const foodContainer = document.getElementById("food-container");
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




 */
