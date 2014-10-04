<!--=============================================================-->

<style>
.speech {
    font-size: 25px;
    width: 25px;
    height: 25px;
    position: absolute;
    margin-left: 5px;
}

.txt {
    height: 100%;
    width: 90%;
}
</style>

<section class="row-fluid">

    <h1 class="lead">Click microphone to start</h1>
    <textarea class="txt" id="txt" placeholder="House {app name} {app command}"></textarea>
    <input class="btn btn-large speech" id="speech" x-webkit-speech />

</section>

<script>
var speech = document.getElementById('speech');
speech.onfocus = speech.blur;
speech.onwebkitspeechchange = function(e) {
    document.getElementById('txt').value = speech.value;
    var voiceInput = 'voice/processVoice?p=' + speech.value;
    window.location.href = voiceInput;
    speech.value = "";
};
</script>
