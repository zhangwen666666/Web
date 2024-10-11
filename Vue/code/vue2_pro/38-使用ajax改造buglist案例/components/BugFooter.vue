<template>
    <div class="footer">
        <button class="small red button" @click="clearSelected">清除已解决</button>
        <span>当前BUG总量{{total}}个，已解决{{selectedCount}}个</span>
    </div>
</template>

<script>
export default {
    name: 'BugFooter',
    // props: ['clearSelectedCallBack', 'bugList','selectedCount'],
    props: ['bugList','selectedCount'],
    methods: {
        clearSelected(){
            // this.clearSelectedCallBack()
            this.$emit('clearSelectedCallBack')
        }
    },
    computed:{
        total(){
            return this.bugList.length
        },
        // selectedCount(){
        //     let count = 0
        //     this.bugList.forEach((bug) => {
        //         if(bug.selected === true)
        //             count++   
        //     })
        //     return count
        // }
    }
}
</script>

<style>
    .footer{
        margin-top: 10px;
    }
    .footer span{
        font-size: 12px;
    }
</style>