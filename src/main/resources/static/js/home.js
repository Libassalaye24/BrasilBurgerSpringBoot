/* const autorisation = document.getElementById("authorize");
let MY_URL = "/api/";
function getUserAuth() {
  
  let url = MY_URL + "securite";

  fetch(url)
    .then((rep) => rep.json())
    .then((data) => {
      console.log(data.userConnected);
      displayAutorisation(data.userConnected)
    });
}
function displayAutorisation(data) {
 
  // let role = user.role.libelle;.\console.log(user);
  let role = data.role.libelle;

    if (role == "ADMIN") {
      autorisation.innerHTML += `
    <a class="a"  th:href="@{/food-liste}">produits</a>
    <a class="a" th:href="@{/complement-liste}" >Complements</a>
    <a class="a" href="">Commandes</a>
    <a class="a" href="">Tableau de bord</a>
    `;
    } else if (role == "CLIENT") {
      autorisation.innerHTML += `
    <a class=""  href="">Mes Commandes</a>
    `;
    }
}

getUserAuth() */