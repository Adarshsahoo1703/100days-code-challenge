#User function Template for python3

class Solution:
    
    #Function to return a list containing the union of the two arrays.
    def findUnion(self,arr1,arr2,n,m):
        '''
        :param a: given sorted array a
        :param n: size of sorted array a
        :param b: given sorted array b
        :param m: size of sorted array b
        :return:  The union of both arrays as a list
        '''
        # code here 
        res = []
        seen = set()
        
        ind1 = ind2 = 0
        
        while ind1 < n and ind2 < m:
            if arr1[ind1] <= arr2[ind2]:
                if arr1[ind1] not in seen:
                    res.append(arr1[ind1])
                seen.add(arr1[ind1])
                ind1 += 1
            else:
                if arr2[ind2] not in seen:
                    res.append(arr2[ind2])
                seen.add(arr2[ind2])
                ind2 += 1
                
        while ind1 < n:
            if arr1[ind1] not in seen:
                res.append(arr1[ind1])
            seen.add(arr1[ind1])
            ind1 += 1
        
        while ind2 < m:
            if arr2[ind2] not in seen:
                res.append(arr2[ind2])
            seen.add(arr2[ind2])
            ind2 += 1
            
        return res


#{ 
 # Driver Code Starts
#Initial Template for Python 3

# Contributed by : Nagendra Jha
# Modified by : Sagar Gupta


if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        n,m = map(int,input().strip().split())
        a = list(map(int,input().strip().split()))
        b = list(map(int,input().strip().split()))
        ob=Solution()
        li = ob.findUnion(a,b,n,m)
        for val in li:
            print(val, end = ' ')
        print()
# } Driver Code Ends