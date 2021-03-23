function loadRoutes() {
    alert("Datos de rutas cargados");
    let xhr = new XMLHttpRequest();
    xhr.open("GET", `Action?option=1`, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const resp = JSON.parse(xhr.responseText);
            if (resp) {
                // alert(resp);
                resp.forEach((route) => {
                    let nameCompany = route.nameCompany;
                    let routes = route.route;
                    let stops = route.numberOfStops;
                    let time = route.duration;
                    let km = route.mileage;
                    let dollar = route.cost;

                    let fila = "<tr><td style='text-align: center'>" + routes + "</td><td style='text-align: center'>" + nameCompany + "</td><td style='text-align: center'>" + time + "</td><td style='text-align: center'>" + km + "</td><td style='text-align: center'>" + stops + "</td><td style='text-align: center'>" + dollar + "</td></tr>";
                    let btn = document.createElement("TR");
                    btn.innerHTML = fila;
                    document.getElementById("table").appendChild(btn);

                    console.log(JSON.stringify(route));
                })
            } else {
                alert("No existe Marichis");
            }
        }
    }
    xhr.send(null);
}

function findRoute() {
    const destination = document.getElementById('destination');
    const index = destination.selectedIndex;
    const nameCity = destination.options[index].text;
    let out = document.getElementById('out');
    if (index === 0) {
        return out.innerHTML = `<strong>Seleccione una opcion valida</strong>`;
    }
    let xhr = new XMLHttpRequest();
    xhr.open("GET", `Action?option=0&index=${index}`, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const resp = JSON.parse(xhr.responseText);
            if (resp) {
                resp.forEach((route) => {
                    let nameCompany = route.nameCompany;
                    let routes = route.route;
                    let stops = route.numberOfStops;
                    let time = route.duration;
                    let km = route.mileage;
                    let dollar = route.cost;

                    let fila = "<tr><td style='text-align: center'>" + routes + "</td><td style='text-align: center'>" + nameCompany + "</td><td style='text-align: center'>" + time + "</td><td style='text-align: center'>" + km + "</td><td style='text-align: center'>" + stops + "</td><td style='text-align: center'>" + dollar + "</td></tr>";
                    let btn = document.createElement("TR");
                    btn.innerHTML = fila;
                    document.getElementById("tabling").appendChild(btn);

                    console.log(JSON.stringify(route));
                })
            } else {
                alert("No existe Marichis");
            }
        }
    }
    xhr.send(null);
}

function showDistance() {
    const destination = document.getElementById('destination');
    const index = destination.selectedIndex;
    const nameCity = destination.options[index].text;
    let out = document.getElementById('out');
    if (index === 0) {
        return out.innerHTML = `<strong>Seleccione una opcion valida</strong>`;
    }
    let xhr = new XMLHttpRequest();
    xhr.open("GET", `Action?option=2&index=${index}`, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const resp = JSON.parse(xhr.responseText);
            if (resp) {
                resp.forEach((route) => {
                    let nameCompany = route.nameCompany;
                    let routes = route.route;
                    let stops = route.numberOfStops;
                    let time = route.duration;
                    let km = route.mileage;
                    let dollar = route.cost;

                    let outOne = document.getElementById('outOne');
                    outOne.innerHTML = `<strong>Ruta: </strong>${routes}<br>
                                        <strong>Empresa: </strong>${nameCompany}<br>
                                        <strong>Duración: </strong>${time}<br>
                                        <strong><span style="color: red">Km: </span></strong>${km}<br>
                                        <strong>Numero de Paradas: </strong>${stops}<br>                                                                      
                                        <strong> Valor Pasaje: </strong>${dollar}`;
                    console.log(JSON.stringify(route));
                })
            } else {
                alert("No existe Marichis");
            }
        }
    }
    xhr.send(null);
}

function showCost() {
    const destination = document.getElementById('destination');
    const index = destination.selectedIndex;
    const nameCity = destination.options[index].text;
    let out = document.getElementById('out');
    if (index === 0) {
        return out.innerHTML = `<strong>Seleccione una opcion valida</strong>`;
    }
    let xhr = new XMLHttpRequest();
    xhr.open("GET", `Action?option=3&index=${index}`, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const resp = JSON.parse(xhr.responseText);
            if (resp) {
                resp.forEach((route) => {
                    let nameCompany = route.nameCompany;
                    let routes = route.route;
                    let stops = route.numberOfStops;
                    let time = route.duration;
                    let km = route.mileage;
                    let dollar = route.cost;

                    let outOne = document.getElementById('outTwo');
                    outOne.innerHTML = `<strong>Ruta: </strong>${routes}<br>
                                        <strong>Empresa: </strong>${nameCompany}<br>
                                        <strong>Duración: </strong>${time}<br>
                                        <strong>Km: </strong>${km}<br>
                                        <strong>Numero de Paradas: </strong>${stops}<br>                                                                      
                                        <strong> <span style="color: red">Valor Pasaje: </span></strong>${dollar}`;
                    console.log(JSON.stringify(route));
                })
            } else {
                alert("No existe Marichis");
            }
        }
    }
    xhr.send(null);
}

function showStops() {
    const destination = document.getElementById('destination');
    const index = destination.selectedIndex;
    const nameCity = destination.options[index].text;
    let out = document.getElementById('out');
    if (index === 0) {
        return out.innerHTML = `<strong>Seleccione una opcion valida</strong>`;
    }
    let xhr = new XMLHttpRequest();
    xhr.open("GET", `Action?option=3&index=${index}`, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const resp = JSON.parse(xhr.responseText);
            if (resp) {
                resp.forEach((route) => {
                    let nameCompany = route.nameCompany;
                    let routes = route.route;
                    let stops = route.numberOfStops;
                    let time = route.duration;
                    let km = route.mileage;
                    let dollar = route.cost;

                    let outOne = document.getElementById('outThree');
                    outOne.innerHTML = `<strong>Ruta: </strong>${routes}<br>
                                        <strong>Empresa: </strong>${nameCompany}<br>
                                        <strong>Duración: </strong>${time}<br>
                                        <strong>Km: </strong>${km}<br>
                                        <strong><span style="color: red">Numero de Paradas: </span></strong>${stops}<br>                                                                      
                                        <strong> Valor Pasaje: </strong>${dollar}`;
                    console.log(JSON.stringify(route));
                })
            } else {
                alert("No existe Marichis");
            }
        }
    }
    xhr.send(null);
}




