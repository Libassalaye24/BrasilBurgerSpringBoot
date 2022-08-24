
const panierContainer = document.getElementById("panier-container");
function showPanier(params) {
    let listPanier = [];
    listPanier = JSON.parse(localStorage.getItem("panier"));

    Array(listPanier).forEach(element => {
        element.forEach(e => {
            const box = document.createElement("div");
            box.classList.add("box");

            const a_remove = document.createElement("a");
            a_remove.classList.add("a-remove");
            const fas_remove = document.createElement("i");
            fas_remove.classList.add("fas");
            fas_remove.classList.add("fa-times");
            a_remove.appendChild(fas_remove);

            const img = document.createElement("img");
            img.src="img/foods/food-4.png";

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
            })
            const br = document.createElement("br");

            const span = document.createElement("span");
            span.innerHTML = "prix : ";
           
            const spanPrice = document.createElement("span");
            spanPrice.classList.add("price");
            spanPrice.innerHTML = `${e.prix} fcfa`;


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

            box.appendChild(a_remove);
            box.appendChild(img);
            box.appendChild(contentDiv);

            panierContainer.appendChild(box);
        })
    });
}

showPanier();

`

<div class="box">
							
<a class="a-remove" href="">
    <i class="fas fa-times"></i>
<a/>

    <img th:src="@{img/foods/food-4.png}" alt="">
    <div class="content">
        <h3>Nom food</h3>
        <span>
            quantite :
        </span>
        <a href="" class="btn-panier">
            <i class="fa fa-plus" aria-hidden="true"></i>
        </a>
        <span class="number">1</span>
        <a href="" class="btn-panier">
            <i class="fa fa-minus" aria-hidden="true"></i>
        </a>
        <br>
        <span>
            prix :
        </span>

        <span class="price">
            1200 fcfa
        </span>
    

    </div>
</div>
`