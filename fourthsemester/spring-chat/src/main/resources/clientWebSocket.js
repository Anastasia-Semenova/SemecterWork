var stompClient;
const currentUserId = '1';
const recipientId = '2'


function send() {
    let msg = document.getElementById("msg").value;
    sendMessage(msg);
    var ul = document.getElementById("messages-list");
    var li = document.createElement("li");
    li.classList.add("your-msg")
    li.appendChild(document.createTextNode(msg));
    ul.appendChild(li);
    document.getElementById("msg").value = '';
}

const sendMessage = (msg) => {
    if (msg.trim() !== "") {
        const message = {
            senderId: currentUserId,
            recipientId: recipientId,
            message: msg,
            date: new Date(),
        };

        stompClient.send("/webSocketApp/chat", {}, JSON.stringify(message));
    }
};
function connect(){
    SockJS = new SockJS("http://localhost:8081/ws");
    stompClient = Stomp.over(SockJS);
    stompClient.connect({}, onConnected, onError);
}
function onError(){
    console.log("error during connection!")
}
function onConnected(){
    document.getElementById("connectionDiv").setAttribute("style", "visibility: hidden;")
    document.getElementById("chatDiv").setAttribute("style", "visibility: visible;")

    stompClient.subscribe(
        "/user/" + currentUserId + "/queue/messages",
        received
    );
}
// function received(message){
//     document.getElementById("messageFromUsers").value=
//         JSON.parse(message.body).message;
// }

function received(message) {
    var ul = document.getElementById("messages-list");
    var li = document.createElement("li");
    li.classList.add("friend-message")
    li.appendChild(document.createTextNode(JSON.parse(message.body).message));
    ul.appendChild(li);
}


