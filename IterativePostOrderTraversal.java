public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> arr = new ArrayList<>();
        TreeNode root = A;
        TreeNode temp = A;
        Stack<TreeNode> stack = new Stack<>();
        while(true){
                // if the root has a right child first push that and then the root
                // make root as root.left
            while(root != null){
                if(root.right != null)
                stack.push(root.right);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                temp = stack.pop();
                if(temp.right != null){
                        
                     /*
                     this is very important -
                     So if we see that the root has a right child and it is at top of the stack
                     it means its right child is not processed. So remove the right child from the stack so that next time
                     it doesnt iterate for the same right child. Also push the root since we will
                     process the root once we have processed the right subtrees. and  then iterate
                     for the right child
                     */
                    if(!stack.isEmpty() && temp.right == stack.peek()){
                        root = stack.pop();
                        stack.push(temp);
                    }
                    else
                    arr.add(temp.val);
                }
                else
                arr.add(temp.val);
            }
            else
            break;
        }
        return arr;
    }
