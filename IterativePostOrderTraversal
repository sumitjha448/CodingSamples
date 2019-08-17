public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> arr = new ArrayList<>();
        TreeNode root = A;
        TreeNode temp = A;
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(root != null){
                if(root.right != null)
                stack.push(root.right);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                temp = stack.pop();
                if(temp.right != null){
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
