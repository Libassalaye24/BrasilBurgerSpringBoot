
const listFood = document.getElementById("allfoods");
const pagination = document.getElementById("pagination");
const typeFoodSelect = document.getElementById("typeFood");
let BASE_URL = "/api/";
function getElement(page, size, type) {
  let typeAvecS = type + "s";
  let url = BASE_URL + typeAvecS + "/" + page + "/" + size;

  fetch(url)
    .then((rep) => rep.json())
    .then((data) => {
      console.log(data);
      afficheElements(data);
      paginationElements(data);
    });
}

function afficheElements(data) {
  listFood.innerHTML = "";
  data["data"].forEach((element) => {
    listFood.innerHTML += `
        <tr>
        <td>
            <input type="checkbox"
             name="tabChecks[]" value="" class="pay-check check-one">
        </td>
        <td>
            <img src="http://localhost:8080/img/foods/${
              element.image
            }" class="img-fluid rounded-top" alt="food" style="width:55px;height:55px">
        </td>
        <td>${element.type == "menu" || element.type == "burger" ? element.nom : element.libelle}</td>
        <td>${element.type == "burger" || element.type == "frite" ? element.prix : element.type == "boisson" ? element.taille.prix : "-"}</td>
        <td>${element.type}</td>
        <td>
            <a name="" id="" class="btn2" href="#"><i class="fa-solid fa-pen-to-square"></i></a>
            <a name="" id="" class="btn2" href="#" role="button"><i class="fa-solid fa-box-archive"></i></a>
        </td>
    </tr>

    `;
  });
}

function paginationElements(data) {
  console.log(data["totalPages"]);
  var pages = [];
  pagination.innerHTML = "";
  for (let i = 0; i < data["totalPages"]; i++) {
    pages.push(i);
  }
  if (data['currentPage'] != 0) {
    pagination.innerHTML += `
    <li class="page-item">
      <a class="page-link" onclick='setPage(${data['currentPage'] - 1},"${data['type']}")'>Precedent</a>
    </li>

  `;
  }
  pages.forEach((item) => {
    if (data["currentPage"] == item) {
      pagination.innerHTML += `
        <li class="page-item " aria-current="page">
          <a class="page-link activ" >${item +1}</a>
        </li>
      `;
    } else {
      pagination.innerHTML += `
        <li class="page-item " aria-current="page">
          <a class="page-link" onclick='setPage(${item},"${data['type']}")'>${item + 1}</a>
        </li>
      `;
    }
  });
  if (data['currentPage'] != data['totalPages']-1) {
    pagination.innerHTML += `
    <li class="page-item">
    <a class="page-link" onclick='setPage(${data['currentPage'] + 1},"${data['type']}")'>Suivant</a>
  </li>
    `
  }
}
function setPage(page ,type = "burger", size = 3) {
  getElement(page, size, type);
}

console.log(typeFoodSelect.value);
setPage(0);

typeFoodSelect.addEventListener("change" , function () {
    setPage(0,typeFoodSelect.value);
})


