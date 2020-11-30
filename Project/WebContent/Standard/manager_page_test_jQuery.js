src="/js/jquery-3.5.1.min.js"
$(document).ready(function(){
	$("#e_name").on("click",function(){
		$("#ename").append("<input type='text' style='width:100px'><input type='submit' value='送出'>")
	})
})


function Cname() {
    let name = document.getElementById("cname");
    if (window.num == 0) {
        name.innerHTML = "<input type='text' style='width:100px'><input type='submit' value='送出'>";
        window.num++;
    } else if (window.num == 1) {
        name.innerHTML = "";
        window.num = 0;
    }
}

function Gmaker() {
    let name = document.getElementById("gmaker");
    if (window.num == 0) {
        name.innerHTML = "<input type='text' style='width:100px'><input type='submit' value='送出'>";
        window.num++;
    } else if (window.num == 1) {
        name.innerHTML = "";
        window.num = 0;
    }
}

function Iss() {
    let name = document.getElementById("iss");
    if (window.num == 0) {
        name.innerHTML = "<input type='text' style='width:100px'><input type='submit' value='送出'>";
        window.num++;
    } else if (window.num == 1) {
        name.innerHTML = "";
        window.num = 0;
    }
}

function Age() {
    let agearray = ["0-6歲", "7-12歲", "12歲以上"];
    let agevalue = ["0-6", "7-12", "12up"];
    let age = document.querySelector("#age");

    if (window.num == 0) {
        for (let i = 0; i < agearray.length; i++) {
            let opt = document.createElement("div");
            opt.innerHTML = "<input type='radio' name='age' value=" + agevalue[i] + ">" + agearray[i];
            age.appendChild(opt);
        }
        window.num++;
    } else if (window.num == 1) {
        age.innerHTML = "";
        window.num = 0;
    }
}

function Type() {
    let typearray = ["大腦", "心理", "重策略", "中策略", "輕策略", "猜心", "兒童", "陣營", "派對", "骰子"];
    //let typevalue = ["0-6", "7-12", "12up"];
    let type = document.querySelector("#type");

    if (window.num == 0) {
        for (let i = 0; i < typearray.length; i++) {
            let opt = document.createElement("div");
            opt.innerHTML = "<input type='radio' name='type'>" + typearray[i];
            type.appendChild(opt);
        }
        window.num++;
    } else if (window.num == 1) {
        type.innerHTML = "";
        window.num = 0;
    }
}

function People() {
    let peoplearray = ["1-2人", "3-6人", "6人以上"];
    let peoplevalue = ["1-2", "3-6", "6up"];
    let people = document.querySelector("#people");

    if (window.num == 0) {
        for (let i = 0; i < peoplearray.length; i++) {
            let opt = document.createElement("div");
            opt.innerHTML = "<input type='radio' name='people' value=" + peoplevalue[i] + ">" + peoplearray[i];
            people.appendChild(opt);
        }
        window.num++;
    } else if (window.num == 1) {
        people.innerHTML = "";
        window.num = 0;
    }
}

function Time() {
    let timearray = ["15分鐘以內", "15-30分鐘", "30-60分鐘", "60分鐘以上"];
    let timevalue = ["15down", "15-30", "30-60", "60up"];
    let time = document.querySelector("#time");

    if (window.num == 0) {
        for (let i = 0; i < timearray.length; i++) {
            let opt = document.createElement("div");
            opt.innerHTML = "<input type='radio' name='time' value=" + timevalue[i] + ">" + timearray[i];
            time.appendChild(opt);
        }
        window.num++;
    } else if (window.num == 1) {
        time.innerHTML = "";
        window.num = 0;
    }
}

function Price() {
    let pricearray = ["$ 0-500", "$ 500-1000", "$ 1000-1500", "$ 1500以上"];
    let pricevalue = ["0-500", "500-1000", "1000-1500", "1500up"];
    let price = document.querySelector("#price");

    if (window.num == 0) {
        for (let i = 0; i < pricearray.length; i++) {
            let opt = document.createElement("div");
            opt.innerHTML = "<input type='radio' name='price' value=" + pricevalue[i] + ">" + pricearray[i];
            price.appendChild(opt);
        }
        window.num++;
    } else if (window.num == 1) {
        price.innerHTML = "";
        window.num = 0;
    }
}
function manager_search_display(){
	let display = document.getElementById("search_fieldset");
	if(window.manager==0){
		display.style.display="";
		window.manager++;
	}else if(window.manager==1){
		display.style.display="none";
		window.manager=0;
	}
	
}
function manager_delete_display(){
	let display = document.getElementById("delete_fieldset");
	if(window.manager==0){
		display.style.display="";
		window.manager++;
	}else if(window.manager==1){
		display.style.display="none";
		window.manager=0;
	}
	
}
function manager_creat_display(){
	let display = document.getElementById("creat_fieldset");
	if(window.manager==0){
		display.style.display="";
		window.manager++;
	}else if(window.manager==1){
		display.style.display="none";
		window.manager=0;
	}
	
}
function manager_update_display(){
	let display = document.getElementById("update_fieldset");
	if(window.manager==0){
		display.style.display="";
		window.manager++;
	}else if(window.manager==1){
		display.style.display="none";
		window.manager=0;
	}
	
}