let canvas, ctx;
let render, init;
let blob;
var flag = 0;
const hiddencost_of_clothes_main = () => {
    const init = () => {
        /*section 01 js */
        const scaling = document.querySelector("#event");
        const target = document.querySelector("#hover_event");
        console.log(target);
        $(function() {
            var target = $('.ptg_bullet_ul li');
            target.mouseover(function() {
                $(this).find('a').css('color', 'white');
                $(this).css('background', '#feb904');
                $(this).css('border-color', '#feb904');
                target.not($(this)).find('a').css('color', 'white');
                target.not($(this)).css('border-color', '#feb904')
                target.not($(this)).css('background', 'transparent')
            })
        })
        var i = 0;
        setInterval(() => {
            scaling_animate_up()
        }, 11000);
        setInterval(() => {
            scaling_b_animate_up()
        }, 9000);
        setInterval(() => {
            scaling_c_animate_up()
        }, 9000);
        if (flag == 0) {
            scaling_animate_up()
            scaling_b_animate_up()
            scaling_c_animate_up()
            flag += 1;
        } else if (flag == 1) {}

        function scaling_animate_up() {
            if (flag == 0) {
                document.getElementById("event").style.visibility = 'visible';
                scaling.style.animation = 'scale 1s forwards';
                scaling.animate([{
                        top: "0%"
                    },
                    {
                        top: "-200%"
                    }
                ], 17000);
            } else if (flag == 1) {
                console.log("1");
                scaling.style.opacity = '0';
                scaling.style.width = '400px';
                scaling.style.height = '400px';
                scaling.style.borderRadius = '400px';
                scaling.style.animation = 'fadein 8s ease-in Infinite Alternate forwards';
                scaling.animate([{
                        top: "40%"
                    },
                    {
                        top: "-200%"
                    }
                ], 17000);
            } /*if*/
        }
    }
    const scaling_b = document.querySelector("#event_b");

    function scaling_b_animate_up() {
        if (flag == 0) {
            document.getElementById("event_b").style.visibility = 'visible';
            scaling_b.style.animation = 'scale 1s forwards';
            scaling_b.animate([{
                top: "-600px"
            }], 9000);

        } else if (flag == 1) {
            scaling_b.style.opacity = '0';
            scaling_b.style.width = '400px';
            scaling_b.style.height = '400px';
            scaling_b.style.borderRadius = '400px';
            scaling_b.style.animation = 'fadein 8s ease-in Infinite Alternate';
            scaling_b.animate([{
                top: "-600px"
            }], 9000);
        } /*if*/
    } /*scaling_b_animate_up */
    const scaling_c = document.querySelector("#event_c");

    function scaling_c_animate_up() {
        if (flag == 0) {
            setTimeout(() => {
                document.getElementById("event_c").style.visibility = 'visible';
                scaling_c.style.animation = 'scale 1s forwards';
                scaling_c.animate([{
                        bottom: "21%"
                    },
                    {
                        bottom: "200%"
                    }
                ], {
                    duration: 18000
                });
            }, 3000);
        } else if (flag == 1) {
            scaling_c.style.opacity = '0';
            scaling_c.style.width = '400px';
            scaling_c.style.height = '400px';
            scaling_c.style.borderRadius = '400px';
            scaling_c.style.animation = 'fadein 8s ease-in Infinite Alternate';
            scaling_c.animate([{
                    bottom: "-20%"
                },
                {
                    bottom: "220%"
                }
            ], {
                duration: 18000
            });
        }
    } /*scaling_c_animate_up*/
    /*section 01 js */
    init();
}
export default hiddencost_of_clothes_main;