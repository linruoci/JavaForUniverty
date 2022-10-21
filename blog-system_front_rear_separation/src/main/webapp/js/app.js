function checkBlog(){

    $.ajax({
        type: 'get',
        url: '../login',

        success: function(body){

        },

        error: function(){

            location.assign('blog-login.html');

        }

    })

}