// XML dosyasını yükleyip tabloya veri ekleyen fonksiyon
function loadXMLData() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            displayStudents(this);
        }
    };
    xhttp.open("GET", "students.xml", true);
    xhttp.send();
}

// XML verileri tabloya işleyen fonksiyon
function displayStudents(xml) {
    const xmlDoc = xml.responseXML;
    const students = xmlDoc.getElementsByTagName("student");
    const table = document.getElementById("students-table");

    for (let i = 0; i < students.length; i++) {
        const row = table.insertRow(-1);

        const number = students[i].getElementsByTagName("number")[0].childNodes[0].nodeValue;
        const name = students[i].getElementsByTagName("name")[0].childNodes[0].nodeValue;

        row.insertCell(0).innerHTML = number;
        row.insertCell(1).innerHTML = name;

        row.onclick = function() {
            showStudentDetails(students[i]);
        };
    }
}

// Detaylarını students-details div'inde gösteren fonksiyon
function showStudentDetails(student) {
    const number = student.getElementsByTagName("number")[0].childNodes[0].nodeValue;
    const name = student.getElementsByTagName("name")[0].childNodes[0].nodeValue;
    const department = student.getElementsByTagName("department")[0].childNodes[0].nodeValue;
    const studentClass = student.getElementsByTagName("class")[0].childNodes[0].nodeValue;


    document.getElementById("detail-number").innerText = number;
    document.getElementById("detail-name").innerText = name;
    document.getElementById("detail-department").innerText = department;
    document.getElementById("detail-class").innerText = studentClass;
    document.getElementById("students-details").style.display = "block";
}

// XML Verisi Çekme
window.onload = loadXMLData;
