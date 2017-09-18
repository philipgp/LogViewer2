 function hideAllEnvironment(){
        $(".envoptionsdiv").hide();
    }
    function hideAllUnderApplication(){
hideAllEnvironment();
hideAllUnderEnvironment();
    }
    function hideAllUnderEnvironment(){
$(".servoptions").parent().hide();
$(".servoptions").prop('checked',false);
hideAllUnderServer();
    }
     function hideAllUnderServer(){
    $(".loggeroptions").parent().hide();
    $(".loggeroptions").prop('checked',false);
  //  hideAllUnderStreamType();
    }
    function hideAllUnderStreamType(){
    $('#streamDiv').hide();
    hideAllFromToDateType();
    }
    function hideAllFromToDateType(){
    $('#fromtodateDiv').hide();
    }
    function hideGoButton(){
    $("#gobutton").hide();
    }
    function showEnvironmentForAppliction(appname){

    hideAllUnderApplication();
    hideAllUnderStreamType();
    hideGoButton();
    //$('#streamDiv').show();
    $(".envoptions").each(function( index ) {
  var currentApp = $(this).attr('app');
  if(currentApp == appname){
  $(this).parent().show();
  }
});
$("#envDiv").show();
    }

    function showServersForEnvironment(environment){

    hideAllUnderEnvironment();
    $(".servoptions").each(function( index ) {
  var currentEnv = $(this).attr('env');
  if(currentEnv == environment){
  $(this).parent().show();
  }
});
$("#servDiv").show();
    }

     function showLoggersForServer(app){

    hideAllUnderServer();
    $('#loggerDiv').show();
    $(".loggeroptions").each(function( index ) {
  var currentApp = $(this).attr('app');
  if(currentApp == app){
  $(this).parent().show();
  }
});

    }
    function showstreamers(){
    $("#streamDiv").show();
    }
    function showFromToDate(){
$("#fromtodateDiv").show();
    }
    function showGoButton(){
    $("#gobutton").show();
    }
$(document).ready(function(){

     $(".appoptions").click(function(){
        showEnvironmentForAppliction($(this).attr("value"));
        hideGoButton();
    });
    $(".envoptions").click(function(){
        showServersForEnvironment($(this).attr("value"));
        showLoggersForServer($('.appoptions:checked').attr("value"));
        showstreamers();
        showGoButton();

    });
     $("#fromtostream").click(function(){
        showFromToDate();
    });


function checkAndDoLogin(){
    var visibleservers = $('.servoptions:visible');
    $( visibleservers).each(function( index ) {
        if($(this).attr('promptPassword')=='true'){
            password =prompt('Enter password for'+$(this).attr('hostname'));
        }
        }
        );
    }
}
     $("#gobutton").click(function(){
        checkAndDoLogin();
    });




});