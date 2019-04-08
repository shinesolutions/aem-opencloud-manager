def trim_skipped(collection):
     '''
     Traverse through collection and trim skipped items
     This is used within AEM OpenCloud Manager for trimming return object
     from filtered `with_filetree` which causes uselessly large object
     A number of `with_filetree` objects are then joined using `with_nested`
     resulting in an even larger object which takes a long time to iterate
     '''

     trimmed_results = []
     for result in collection['results']:
        if 'skipped' in result and result['skipped'] == True:
            result = None
        else:
            if 'item' in result and 'skipped' in result['item'] and result['item']['skipped'] == True:
                result = None
            else:
                trimmed_results.append(result)

     collection['results'] = trimmed_results
     return collection

class FilterModule(object):
    '''
    Custom jinja2 filters for trimming skipped items from Ansible payload
    '''

    def filters(self):
        return {
            'trim_skipped': trim_skipped
        }
